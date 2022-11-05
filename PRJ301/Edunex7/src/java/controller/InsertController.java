/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentDAO;

/**
 *
 * @author manhn
 */
public class InsertController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            boolean gender = request.getParameter("gender").equals("0");
            Student s = new Student(name, gender);
            if (StudentDAO.insert(s)) {
                request.setAttribute("error", "Insert successful");
            }
            else {
                request.setAttribute("error", "Insert failed");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            request.setAttribute("error", "Insert failed");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
