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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Patient;
import modal.Staff;
import modal.User;
/**
 *
 * @author Marken Tuan Nguyen
 */
public class SignUpServlet extends HttpServlet {

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
        String patientTable = null;
        String staffTable = null;
        
//      apply context into database
        DBbean db =  new DBbean();
        db.getConnection(conn);
        
//      get parameter from front-end file
        String username = request.getParameter("us");
        String password = request.getParameter("pw");
        String role     = request.getParameter("role");
        String name     = request.getParameter("name");
        String address  = request.getParameter("addr");
        String action   = request.getParameter("act");
        
//      declare role
        User user = new User();
        Staff staff = new Staff();
        Patient patient = new Patient();
        
//      save path string
        String path = null;
        
        //      if front-end click btn Register
        if(action.equals("SignUp")){
//          init path
            path = "view/jsp/RegisterPage.jsp";
        } else if(action.equals("Register")){
//          create user from DBbean.createUser
            db.createUser(userTable, username, password, role);
            
            System.out.println("PATIENT NAME: "+ patient.getPatientName());
            System.out.println("PATIENT ADDRESS: "+patient.getPatientAddress());
            
            
//          init path
            path = "/index.html";
        } else if (action.equals("GoBack")){
//          init path
            path = "/index.html";
        
        }
//      access path
        request.getRequestDispatcher(path).forward(request,response);

        switch(role){
            case "Patient":
                patientTable = (String) getServletContext().getAttribute("patientTable");
                patient.setPatientName(name);
                patient.setPatientAddress(address);
                db.createPatient(patientTable, patient.getPatientName(), patient.getPatientAddress());
//                request.setAttribute("patientData", patient);
                break;
            case "Doctor":
            case "Nurse":
                staffTable = (String) getServletContext().getAttribute("staffTable");
                staff.setStaffName(name);
                staff.setStaffAddress(address);
                db.createStaff(staffTable, staff.getStaffName(), staff.getStaffAddress());
//                request.setAttribute("staffData", staff);
                break;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
