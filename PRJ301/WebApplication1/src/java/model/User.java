/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author manhn
 */
public class User {

    private String username;
    private String password;
    private String fullName;
    private String address;
    private String dob;
    private boolean gender;

    public User() {
    }

    public User(String username, String password, String fullName, String address, String dob, boolean gender) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return this.gender;
    }

    public boolean getGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User fullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public User address(String address) {
        setAddress(address);
        return this;
    }

    public User dob(String dob) {
        setDob(dob);
        return this;
    }

    public User gender(boolean gender) {
        setGender(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password)
                && Objects.equals(fullName, user.fullName) && Objects.equals(address, user.address)
                && Objects.equals(dob, user.dob) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullName, address, dob, gender);
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", fullName='" + getFullName() + "'" +
                ", address='" + getAddress() + "'" +
                ", dob='" + getDob() + "'" +
                ", gender='" + isGender() + "'" +
                "}";
    }

    public static User getByUsername(String username) {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tblUser WHERE account=?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            if (!result.next())
                return null;
            return new User()
                .username(result.getString("account").trim())
                .password(result.getString("pass").trim())
                .fullName(result.getString("name").trim())
                .address(result.getString("address").trim())
                .gender(result.getBoolean("gender"))
                .dob(result.getString("dateofbirth").trim())
            ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<User> getAll() {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tblUser");
            ResultSet result = stmt.executeQuery();
            List<User> ret = new ArrayList<>();
            while (result.next()) {
                ret.add(new User()
                    .username(result.getString("account").trim())
                    .password(result.getString("pass").trim())
                    .fullName(result.getString("name").trim())
                    .address(result.getString("address").trim())
                    .gender(result.getBoolean("gender"))
                    .dob(result.getString("dateofbirth").trim())
                );
            }
            return ret;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean update() {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE tblUser SET pass=?, name=?, address=?, gender=?, dateofbirth=? WHERE account=?");
            stmt.setString(1, password);
            stmt.setString(2, fullName);
            stmt.setString(3, address);
            stmt.setBoolean(4, gender);
            stmt.setString(5, dob);
            stmt.setString(6, username);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
