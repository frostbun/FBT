/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author manhn
 */
public class AddController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = Student.getAll();
        List<Department> departments = Department.getAll();
        request.setAttribute("students", students);
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("student.jsp").include(request, response);
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            boolean gender = request.getParameter("gender").equals("male");
            int did = Integer.parseInt(request.getParameter("did"));
            if (!new Student(id, name, gender, did).insert()) {
                request.setAttribute("error", "Failed to create Student!");
                return;
            }
            request.setAttribute("skip", 1);
        }
        catch (NullPointerException | NumberFormatException e) {
            System.out.println(e.getMessage());
            request.setAttribute("error", "Something went wrong!");
        }
        finally {
            doGet(request, response);
        }
    }
}
