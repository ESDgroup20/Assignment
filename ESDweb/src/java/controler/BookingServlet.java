/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.DBbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Patient;
import model.User;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BookingServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        String patientTable = (String) getServletContext().getAttribute("patientTable");

//      apply context into database
        DBbean db =  new DBbean();
        db.getConnection(conn);        
        
        
        String action   = request.getParameter("act");
        if(action.equals("Book")){
            User user = (User) session.getAttribute("userData");
            
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String doctor = request.getParameter("doctorName");
            
            System.out.println("Booking: ");
            System.out.println(date+ " at " +time);
            System.out.println("doctor:" + doctor);
            System.out.println("username: "+user.getUserName());
            System.out.println("password: "+user.getUserPass());
            
            String patientName = db.selectNameByRole(patientTable, "Patient", "patientname", user.getUserName(), user.getUserPass());
            System.out.println("Patient name: "+patientName);
        }

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
