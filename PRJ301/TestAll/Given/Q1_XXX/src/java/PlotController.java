/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.MyPoint;

/**
 *
 * @author manhn
 */
public class PlotController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int n = Integer.parseInt(request.getParameter("num"));
            List<MyPoint> list = new ArrayList();
            Random rand = new Random();
            while (n-->0) {
                list.add(new MyPoint(Math.abs(rand.nextInt()%100/10*10), Math.abs(rand.nextInt()%100)));
            }
            request.setAttribute("data", list);
        }
        catch (NullPointerException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        finally {
            request.getRequestDispatcher("display.jsp").forward(request, response);
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
