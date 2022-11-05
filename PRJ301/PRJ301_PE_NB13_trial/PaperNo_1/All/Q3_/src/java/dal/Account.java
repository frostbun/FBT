/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author manhn
 */
public class Account {
    private String username;
    private String password;
    private String name;

    public Account(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public static Account findByUsername(String username) {
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account WHERE userid=?");
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            return res.next()
                ? new Account(
                    username,
                    res.getString("password"),
                    res.getString("displayname")
                )
                : null;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
