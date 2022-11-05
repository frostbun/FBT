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
public class StudentDAO {
    
    public static boolean insert(Student s) {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Student(Fullname, Gender) VALUES (?, ?)");
            stmt.setString(1, s.getName());
            stmt.setBoolean(2, s.isGender());
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean update(Student s) {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Student SET Fullname=?, Gender=? WHERE IDStudent=?");
            stmt.setString(1, s.getName());
            stmt.setBoolean(2, s.isGender());
            stmt.setInt(3, s.getIdStudent());
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean delete(int id) {
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Student WHERE IDStudent=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Student> findAll() {
        List<Student> ret = new ArrayList<Student>();
        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Student");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                ret.add(new Student(
                    result.getInt("IDStudent"),
                    result.getString("Fullname"),
                    result.getBoolean("Gender")
                ));
            }
            return ret;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return ret;
        }
    }
}
