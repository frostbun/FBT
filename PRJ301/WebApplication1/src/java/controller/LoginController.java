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

import model.User;

/**
 *
 * @author manhn
 */
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = User.getByUsername(username);
            if (user == null) {
                request.setAttribute("result", "Login Failed!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            if (!user.checkPassword(password)) {
                response.sendRedirect("reset");
                return;
            }
            request.setAttribute("name", user.getFullName());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        catch (NullPointerException e) {
            request.setAttribute("result", e.getMessage());
        }
        finally {
        }
    }
}
