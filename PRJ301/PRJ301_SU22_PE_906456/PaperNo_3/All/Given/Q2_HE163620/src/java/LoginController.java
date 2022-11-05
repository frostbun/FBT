/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author manhn
 */
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<form method='post'>");
            out.println("Username: <input name='username'><br>");
            out.println("Password: <input name='password'><br>");
            out.println("<button>Login</button>");
            out.println("</form>");
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Account account = Account.findByUsername(request.getParameter("username"));
            if (account != null && account.checkPassword(request.getParameter("password"))) {
                out.println("Login Successful!");
                request.getSession().setAttribute("account", account);
            }
            else {
                out.println("Login Failed.");
            }
        }
    }
}
