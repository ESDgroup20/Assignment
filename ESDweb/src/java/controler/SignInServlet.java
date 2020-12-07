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
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.User;

/**
 *
 * @author Marken Tuan Nguyen
 */


public class SignInServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
//      get context from BaseListener
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        String userTable = (String) getServletContext().getAttribute("userTable");

        
//      Set session at beginning
        HttpSession session = request.getSession();
                
//      apply context into database
        DBbean db =  new DBbean();
        db.getConnection(conn);
        
//      get parameter from front-end file
        String username = request.getParameter("us");
        String password = request.getParameter("pw");
        String datetime = request.getParameter("date");
        String action   = request.getParameter("act");
        
//      save path string       
        String path = null;
//        if front-end click btn Login
        if(action.equals("Login")){
//          check Auth from DBbean.signInAuth
            User user = db.signInAuth(userTable, username,password);
//          check valid user            
            if (user != null) {
//              session for users
                session.setAttribute("userData", user);
//              session key of users
                session.setAttribute("sessionKey", session.getId());
//              init path
                path = "view/jsp/pages/SuccessPage.jsp";
            } else { // if invalid
//              init path
                path = "view/jsp/pages/ErrorPage.jsp";
            }
            
//        if front-end click btn FastTrack
        }else if(action.equals("FastTrack")){
//          access user table
            String s = db.signInSelection(userTable);
            request.setAttribute("str", s);
            path = "view/jsp/pages/TestPage.jsp";
            
        }
//      access path
        request.getRequestDispatcher(path).forward(request,response);
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
