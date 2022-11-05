package j1_l_p0005;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account {

    private static final String DB_USERNAME = "lab";
    private static final String DB_PASSWORD = "12345678";
    private static final String DB_HOST = "jdbc:mysql://localhost/lab_j1_l_p0005";

    private final String id;
    private final String name;
    private String password;
    private double balance;

    public Account(String id, String name, String password) {
        this(id, name, hash(password), 0);
    }

    private Account(String id, String name, String password, double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    private boolean updateBalance(double amount) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Account SET balance=? WHERE id=?");
            stmt.setDouble(1, this.balance + amount);
            stmt.setString(2, this.id);
            if (stmt.executeUpdate() > 0) {
                this.balance += amount;
                return true;
            }
            return false;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validatePassword(String password) {
        return hash(password).equals(this.password);
    }

    public void setPassword(String password) {
        this.password = hash(password);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        return updateBalance(-amount);
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        return updateBalance(amount);
    }

    public boolean transfer(double amount, Account other) {
        if (amount <= 0 || amount > this.balance) return false;
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("UPDATE Account SET balance=? WHERE id=?");
            // withdraw
            stmt.setDouble(1, this.balance - amount);
            stmt.setString(2, this.id);
            if (stmt.executeUpdate() == 0) {
                conn.rollback();
                return false;
            }
            // deposit
            stmt.setDouble(1, other.balance + amount);
            stmt.setString(2, other.id);
            if (stmt.executeUpdate() == 0) {
                conn.rollback();
                return false;
            }
            // commit
            conn.commit();
            this.balance -= amount;
            other.balance += amount;
            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean insert() {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Account (id, name, password, balance) VALUES (?, ?, ?, ?)");
            stmt.setString(1, this.id);
            stmt.setString(2, this.name);
            stmt.setString(3, this.password);
            stmt.setDouble(4, this.balance);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Account WHERE id=?");
            stmt.setString(1, this.id);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Account get(String id) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account WHERE id=?");
            stmt.setString(1, id);
            ResultSet result = stmt.executeQuery();
            if (!result.next()) return null;
            return new Account(
                result.getString("id"),
                result.getString("name"),
                result.getString("password"),
                result.getDouble("balance")
            );
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String hash(String password) {
        try {
            byte[] hashedPass = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b: hashedPass) {
                builder.append(Integer.toHexString(b & 0xff));
            }
            return builder.toString();
        }
        catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
