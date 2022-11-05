/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manhn
 */
public class Book {
    private int id;
    private String name;
    private String addedBy;
    private String addedAt;
    private boolean online;

    public Book(int id, String name, String addedBy, String addedAt, boolean online) {
        this.id = id;
        this.name = name;
        this.addedBy = addedBy;
        this.addedAt = addedAt;
        this.online = online;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public boolean isOnline() {
        return online;
    }
    
    public String getOnlineString() {
        return online ? "Yes" : "No";
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
    
    public static List<Book> findByAdder(String username) {
        List<Book> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Book WHERE added_by=?");
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                ret.add(new Book(
                    res.getInt("bid"),
                    res.getString("name"),
                    res.getString("added_by"),
                    res.getString("added_date"),
                    res.getBoolean("isOnline")
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return ret;
        }
    }
}
