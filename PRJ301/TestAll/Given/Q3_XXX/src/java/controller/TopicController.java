/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comment;
import model.Topic;

/**
 *
 * @author sonnt
 */
public class TopicController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Topic> questions = new ArrayList<>();
        Topic q1 = new Topic();
        q1.setTitle("Topic 1");
        Comment q1_a1 = new Comment();
        q1_a1.setContent("Comment 1");
        q1.getComments().add(q1_a1);
        Comment q1_a2 = new Comment();
        q1_a2.setContent("Comment 2");
        q1.getComments().add(q1_a2);
        Comment q1_a3 = new Comment();
        q1_a3.setContent("Comment 3");
        q1.getComments().add(q1_a3);
        Comment q1_a4 = new Comment();
        q1_a4.setContent("Comment 4");
        q1.getComments().add(q1_a4);
        questions.add(q1);
        
        Topic q2 = new Topic();
        q2.setTitle("Topic 2");
        Comment q2_a1 = new Comment();
        q2_a1.setContent("Comment 5");
        q2.getComments().add(q2_a1);
        Comment q2_a2 = new Comment();
        q2_a2.setContent("Comment 6");
        q2.getComments().add(q2_a2);
        Comment q2_a3 = new Comment();
        q2_a3.setContent("Comment 7");
        q2.getComments().add(q2_a3);
        Comment q2_a4 = new Comment();
        q2_a4.setContent("Comment 8");
        q2.getComments().add(q2_a4);
        questions.add(q2);
                
        request.setAttribute("data", questions);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
