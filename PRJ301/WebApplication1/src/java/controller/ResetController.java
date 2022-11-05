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
import java.util.Random;
import model.User;

/**
 *
 * @author manhn
 */
public class ResetController extends HttpServlet {

    public static String randomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("reset.jsp").forward(request, response);
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String dob = request.getParameter("dob");
            User user = User.getByUsername(username);
            if (user == null) {
                request.setAttribute("result", "Wrong account");
                return;
            }
            if (!user.getDob().equals(dob)) {
                request.setAttribute("result", "Wrong birthdate");
                return;
            }
            String password = randomPassword(8);
            user.password(password).update();
            request.setAttribute("password", password);
        }
        catch (NullPointerException e) {
        }
        finally {
            request.getRequestDispatcher("reset.jsp").forward(request, response);
        }
    }
}
