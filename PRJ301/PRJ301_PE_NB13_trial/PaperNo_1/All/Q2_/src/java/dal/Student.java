package dal;

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
    private int sid;
    private String name;
    private int gender;
    private String dob;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public Student(int sid, String name, int gender, String dob) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
    
    public static List<Student> findByNameContains(String name) {
        if (name == null) {
            name = "";
        }
        List<Student> students = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Student WHERE name LIKE ?");
            stmt.setString(1, "%"+name+"%");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                students.add(new Student(
                    res.getInt("sid"),
                    res.getString("name"),
                    res.getInt("gender"),
                    res.getString("dob")
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return students;
        }
    }
}
