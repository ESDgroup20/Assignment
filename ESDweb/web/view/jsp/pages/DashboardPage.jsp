<%-- 
    Document   : Dashboard
    Created on : 06-Dec-2020, 01:46:22
    Author     : ESD20
--%>


<%@page import="model.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    </head>
    <body>

        <%
<<<<<<< Updated upstream
            System.out.println("Dashboard page opened");
            UserBean user = (UserBean) request.getSession().getAttribute("userData");
            String role = user.getRole();
            System.out.println("role="+role);
            
            if(role.equals("Admin")){
                System.out.println("adminView Opened");
        %>      
                <h1> Dashboard <% out.print(role); %> </h1>
                <%--<%@ include file="../components/AdminDashboard.jsp" %>--%>
                <%@ include file="../components/AdminView.jsp" %>
        <%  } 
            else if(role.equals("Patient")){
                String patientName = user.getName();
        %>
                <h1> Dashboard <% out.print(role + " " + patientName); %> </h1>
                <%@ include file="../components/Booking.jsp" %>
        <%  }
            else{
        %>
                <h1> Dashboard <% out.print(role); %> </h1>
=======
            User user = (User) request.getSession().getAttribute("userData");
            String role = user.getUserRole();
            System.out.println("adddaffrequest.getSession()" + request.getSession());
            if (role.equals("Admin")) {
        %>      
        <h1><% out.print(role); %>  Dashboard </h1>

        <%@ include file="../pages/admin/AdminDashboard.jsp" %>
        <%  } else if (role.equals("Patient")) {
            String patientName = (String) request.getSession().getAttribute("patientName");
        %>
        <h1> Welcome, <% out.print(role + " " + patientName); %> </h1>
        <%@ include file="../pages/patient/PatientDashboard.jsp" %>
        <%  } else {
            String staffName = (String) request.getSession().getAttribute("staffName");
            
        %>      
        <h1> Welcome, <% out.print(role + " " + staffName);%> </h1>
        <%@ include file="../pages/staff/StaffDashboard.jsp" %>
>>>>>>> Stashed changes
        <%  }
        %>        

    </body>
    <footer>
        <%@ include file="../components/Footer.jsp" %>
    </footer>
</html>
