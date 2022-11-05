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
import java.util.Objects;

/**
 *
 * @author manhn
 */
public class Application {
    private int id;
    private String name;
    private String registeredBy;
    private String registeredAt;
    private boolean active;

    public Application(int id, String name, String registeredBy, String registeredAt, boolean active) {
        this.id = id;
        this.name = name;
        this.registeredBy = registeredBy;
        this.registeredAt = registeredAt;
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Application other = (Application) obj;
        return this.id == other.id;
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

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public static Application findById(int id) {
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Application WHERE aid=?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            return res.next()
                ? new Application(
                    id,
                    res.getString("name"),
                    res.getString("registered_by"),
                    res.getString("register_date"),
                    res.getBoolean("isActive")
                )
                : null;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<Application> findAll() {
        List<Application> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Application");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                ret.add(new Application(
                    res.getInt("aid"),
                    res.getString("name"),
                    res.getString("registered_by"),
                    res.getString("register_date"),
                    res.getBoolean("isActive")
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
