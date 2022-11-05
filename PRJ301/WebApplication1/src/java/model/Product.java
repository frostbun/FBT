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

/**
 *
 * @author manhn
 */
public class Product {
    private String id;
    private String name;
    private String image;
    private String unit;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String id, String name, String image, String unit, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.unit = unit;
        this.price = price;
    }

    public static Product getById(String id) {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tblProduct WHERE ProductID=?");
            stmt.setString(1, id);
            ResultSet result = stmt.executeQuery();
            if (!result.next()) return null;
            return new Product(
                result.getString("ProductID").trim(),
                result.getString("ProductName").trim(),
                result.getString("Image").trim(),
                result.getString("Unit").trim(),
                result.getDouble("Price")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<Product> getAll() {
        List<Product> ret = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tblProduct");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                ret.add(new Product(
                    result.getString("ProductID").trim(),
                    result.getString("ProductName").trim(),
                    result.getString("Image").trim(),
                    result.getString("Unit").trim(),
                    result.getDouble("Price")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return ret;
        }
    }
}
