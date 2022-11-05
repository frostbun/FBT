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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author manhn
 */
public class Category {
    private int id;
    private String name;
    private Map<Application, Float> applications; 

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        loadApplications();
    }

    public Map<Application, Float> getApplications() {
        return applications;
    }
    
    public void loadApplications() {
        this.applications = new HashMap<>();
        List<Application> applications = Application.findAll();
        for (Application application: applications) {
            this.applications.put(application, ApplicationCategory.findByApplicationAndCategory(application, this).getDegree());
        }
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
    
    public static Category findById(int id) {
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Category WHERE cid=?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            return res.next()
                ? new Category(
                    id,
                    res.getString("name")
                )
                : null;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<Category> findAll() {
        List<Category> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Category");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                ret.add(new Category(
                    res.getInt("cid"),
                    res.getString("name")
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
