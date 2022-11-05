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
public class Thread {
    private int tid;
    private String content;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Thread(int tid, String content) {
        this.tid = tid;
        this.content = content;
    }
    
    public static List<Thread> findAll() {
        List<Thread> threads = new ArrayList<>();
        try (Connection conn = new DBContext().connection) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Thread");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                threads.add(new Thread(
                    res.getInt("tid"),
                    res.getString("tcontent")
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return threads;
        }
    }
}
