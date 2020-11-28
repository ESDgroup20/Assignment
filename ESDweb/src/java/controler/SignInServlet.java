/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.user.User;
import modal.utils.SignInDAO;

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
        
        String path = null;
        SignInDAO login = new SignInDAO();
        String username = request.getParameter("us");
        String password = request.getParameter("pw");
        String action   = request.getParameter("act");
        
       
        if(action.equals("Login")){
            User user = login.signInAuth(username,password);
            
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("data", user);
                session.setAttribute("sessionKey", session.getId());
                
                path = "/view/SuccessPage.jsp";
                System.out.println("is new: "+session.isNew());
                if(session.isNew()) {
                    path = "index.html";
                }
            } else {
                path = "/view/ErrorPage.jsp";
            }
        } else if(action.equals("Register")){
        
            path = "/view/RegisterPage.jsp";
            
        }else if(action.equals("FastTrack")){
            String s = login.signInSelection();
//            System.out.println("s= "+s);
            request.setAttribute("str", s);
            path = "/view/TestPage.jsp";
            
        }
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
