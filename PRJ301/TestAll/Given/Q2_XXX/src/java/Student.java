
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
public class Student {
    private int id;
    private String name;
    private boolean gender;
    private int did;
    private String dName;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Student(int id, String name, boolean gender, int did) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.did = did;
    }
    
    public Student(int id, String name, boolean gender, String dName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dName = dName;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
    
    public boolean insert() {
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO Student(id, name, gender, did) " +
                "VALUES (?, ?, ?, ?) "
            );
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setBoolean(3, gender);
            stmt.setInt(4, did);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Student> getAll() {
        List<Student> ret = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT Student.id, sName = Student.name, Student.gender, dName = Department.name " +
                "FROM Student " +
                "LEFT JOIN Department " +
                "ON Student.did = Department.id"
            );
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                ret.add(new Student(
                    result.getInt("id"),
                    result.getString("sName"),
                    result.getBoolean("gender"),
                    result.getString("dName")
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
