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
import model.Answer;
import model.Question;

/**
 *
 * @author sonnt
 */
public class QuestionController extends HttpServlet {

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
        ArrayList<Question> questions = new ArrayList<>();
        Question q1 = new Question();
        q1.setContent("Question 1");
        Answer q1_a1 = new Answer();
        q1_a1.setContent("Answer 1");
        q1.getAnswers().add(q1_a1);
        Answer q1_a2 = new Answer();
        q1_a2.setContent("Answer 2");
        q1.getAnswers().add(q1_a2);
        Answer q1_a3 = new Answer();
        q1_a3.setContent("Answer 3");
        q1.getAnswers().add(q1_a3);
        Answer q1_a4 = new Answer();
        q1_a4.setContent("Answer 4");
        q1.getAnswers().add(q1_a4);
        questions.add(q1);
        
        Question q2 = new Question();
        q2.setContent("Question 2");
        Answer q2_a1 = new Answer();
        q2_a1.setContent("Answer 5");
        q2.getAnswers().add(q2_a1);
        Answer q2_a2 = new Answer();
        q2_a2.setContent("Answer 6");
        q2.getAnswers().add(q2_a2);
        Answer q2_a3 = new Answer();
        q2_a3.setContent("Answer 7");
        q2.getAnswers().add(q2_a3);
        Answer q2_a4 = new Answer();
        q2_a4.setContent("Answer 8");
        q2.getAnswers().add(q2_a4);
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
