/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.Account;
import dal.Thread;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author manhn
 */
@WebServlet(urlPatterns={"/discuss"})
public class DiscussController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account)request.getSession().getAttribute("account");
        if (account == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("access denied");
            }
            return;
        }
        request.setAttribute("threads", Thread.findAll());
        request.getRequestDispatcher("discuss.jsp").forward(request, response);
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account)request.getSession().getAttribute("account");
        if (account == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("access denied");
            }
        }
    }
}
