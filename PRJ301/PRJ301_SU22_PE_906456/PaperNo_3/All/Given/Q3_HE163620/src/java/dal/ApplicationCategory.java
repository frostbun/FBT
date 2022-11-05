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
public class ApplicationCategory {
    private Application application;
    private Category category;
    private float degree;

    public ApplicationCategory(Application application, Category category, float degree) {
        this.application = application;
        this.category = category;
        this.degree = degree;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        this.degree = degree;
    }
    
    public static ApplicationCategory findByApplicationAndCategory(Application application, Category category) {
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Application_Category WHERE aid=? AND cid=?");
            stmt.setInt(1, application.getId());
            stmt.setInt(2, category.getId());
            ResultSet res = stmt.executeQuery();
            return res.next()
                ? new ApplicationCategory(
                    application,
                    category,
                    res.getFloat("relatedDegree")
                )
                : null;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<ApplicationCategory> findAll() {
        List<ApplicationCategory> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Application_Category");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                ret.add(new ApplicationCategory(
                    Application.findById(res.getInt("aid")),
                    Category.findById(res.getInt("cid")),
                    res.getFloat("relatedDegree")
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
