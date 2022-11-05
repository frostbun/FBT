
import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manhn
 */
public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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
    
    public static List<Department> getAll() {
        List<Department> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Department");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                ret.add(new Department(
                    result.getInt("id"),
                    result.getString("name")
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
