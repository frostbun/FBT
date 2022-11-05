package j1_l_p0002_db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private static final String DB_USERNAME = "lab";
    private static final String DB_PASSWORD = "12345678";
    private static final String DB_HOST = "jdbc:mysql://localhost/lab_j1_l_p_0002";

    private final String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;

    public User(String username, String firstName, String lastName, String password, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public static User get(String username) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE username=?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            if (!result.next()) return null;
            return new User(
                result.getString("username"),
                result.getString("firstname"),
                result.getString("lastname"),
                result.getString("password"),
                result.getString("phone"),
                result.getString("email")
            );
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<User> getAll() {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM user");
            List<User> userList = new ArrayList<>();
            while (result.next()) {
                userList.add(
                    new User(
                        result.getString("username"),
                        result.getString("firstname"),
                        result.getString("lastname"),
                        result.getString("password"),
                        result.getString("phone"),
                        result.getString("email")
                    )
                );
            }
            return userList;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<User> search(String name) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE LOWER(firstname) LIKE LOWER(?) OR LOWER(lastname) LIKE LOWER(?)");
            name = "%" + name + "%";
            stmt.setString(1, name);
            stmt.setString(2, name);
            ResultSet result = stmt.executeQuery();
            List<User> userList = new ArrayList<>();
            while (result.next()) {
                userList.add(
                    new User(
                        result.getString("username"),
                        result.getString("firstname"),
                        result.getString("lastname"),
                        result.getString("password"),
                        result.getString("phone"),
                        result.getString("email")
                    )
                );
            }
            return userList;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static boolean insert(User user) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (username, firstname, lastname, password, phone, email) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, user.username);
            stmt.setString(2, user.firstName);
            stmt.setString(3, user.lastName);
            stmt.setString(4, user.password);
            stmt.setString(5, user.phone);
            stmt.setString(6, user.email);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean update(User user) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE user SET firstname=?, lastname=?, password=?, phone=?, email=? WHERE username=?");
            stmt.setString(1, user.firstName);
            stmt.setString(2, user.lastName);
            stmt.setString(3, user.password);
            stmt.setString(4, user.phone);
            stmt.setString(5, user.email);
            stmt.setString(6, user.username);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean delete(User user) {
        try (Connection conn = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE username=?");
            stmt.setString(1, user.username);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s | %-10s | %-10s | %s | %s",
            username,
            firstName,
            lastName,
            phone,
            email
        );
    }

    public boolean validatePassword(String password) {
        return hashPassword(password).equals(this.password);
    }

    public static String hashPassword(String password) {
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
