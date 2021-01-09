/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.DBbean;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PatientBean;
import model.StaffBean;
import model.UserBean;

/**
 *
 * @author ESD20
 */
@WebServlet("/RegisterPage")
public class SignUpServlet extends HttpServlet {

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

//      get context from BaseListener
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        String userTable = (String) getServletContext().getAttribute("userTable");

        HttpSession session = request.getSession(false);

//      apply context into database
        DBbean db = new DBbean();
        db.getConnection(conn);

//      get parameter from front-end file
        String action   = request.getParameter("act");
        String username = request.getParameter("us");
        String password = request.getParameter("pw");
        String role     = request.getParameter("role");
        String name     = request.getParameter("name");
        
        String number   = request.getParameter("number");
        String route    = request.getParameter("route");
        String postcode = request.getParameter("postcode");
        String city     = request.getParameter("city");
        String area     = request.getParameter("area");
        String country  = request.getParameter("country");
        String address = number+", "+route+", "+postcode+", "+city+", "+area+", "+country;
        

//      save path string
        String path = null;

        //      if front-end click btn Register
        if (action.equals("Register")) {

//          init path
            path = "/view/jsp/pages/RegisterPage.jsp";
        } else if(action.equals("SignUp")){
//          create user from DBbean.createUser
            db.createUser(userTable, username, password, role);     
            

            switch (role) {
                case "Patient":
                    PatientBean patient = new PatientBean();
                    patient.setName(name);
                    patient.setUserName(username);
                    String patientTable = (String) getServletContext().getAttribute("patientTable");
                    db.createPatient(patientTable, name, address, username);
                    session.setAttribute("patientData", patient);
                    break;
    
                case "Doctor":
                case "Nurse":
                    StaffBean staff = new StaffBean();
                    staff.setName(name);
                    staff.setUserName(username);
                    String staffTable = (String) getServletContext().getAttribute("staffTable");
                    db.createStaff(staffTable, name, address, username);
                    session.setAttribute("staffData", staff);
                    break;
            }

            
//          init path
            path = "/view/jsp/pages/SuccessPage.jsp";
        }
//      access path
        request.getServletContext().getRequestDispatcher(path).forward(request,response);

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
