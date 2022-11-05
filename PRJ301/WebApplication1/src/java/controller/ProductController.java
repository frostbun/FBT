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
import java.util.List;
import model.Product;
import org.apache.catalina.ant.StartTask;

/**
 *
 * @author manhn
 */
public class ProductController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int pageSize = 4;
        String p = request.getParameter("page");
        int page = p != null ? Integer.parseInt(p) : 1;
        List<Product> productList = Product.getAll();
        int count = productList.size();
        int lastPage = (count + pageSize-1) / pageSize;
        int start = (page-1) * pageSize;
        int end = start + pageSize;
        request.setAttribute("list", productList.subList(start, Integer.min(end, count)));
        request.setAttribute("page", page);
        request.setAttribute("lastPage", lastPage);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
