<%-- 
    Document   : LoginJSP
    Created on : 22-Nov-2020, 13:59:03
    Author     : Marken Tuan Nguyen
--%>

<%@page import="modal.Staff"%>
<%@page import="modal.Patient"%>
<%@page import="modal.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./view/js/datetime.js" type="text/javascript"></script>
       
        <title>Success Page</title>
    </head>
    <body>
        
        <% 
            String action   = request.getParameter("act");
            if(action.equals("Login")){ 
                String sessionKey = (String) request.getSession().getAttribute("sessionKey");
                out.println("<br>SESSION key: "+sessionKey);
        %>
                <jsp:useBean id="user" class="modal.User" scope="request" >
                    <h1>LOGIN SUCCESSFULLY</h1> 
                    USERNAME is: <jsp:getProperty name="userData" property="userName" /><br>
                    PASSWORD is: <jsp:getProperty name="userData" property="userPass" /><br>
                    ROLE     is: <jsp:getProperty name="userData" property="userRole" /><br>
                </jsp:useBean>
                    
        <%  } else if(action.equals("SignUp")) {
                String role = request.getParameter("role");
                if(role.equals("Patient")){
        %>
                    <jsp:useBean id="patient" class="modal.Patient" scope="request" >
                        <h1>REGISTER SUCCESSFULLY</h1>
                        USERNAME       is: <jsp:getProperty name="patientdata" property="patientUsername" /><br>
                        PASSWORD       is: <jsp:getProperty name="patientdata" property="patientPassword" /><br>
                        PATIENTNAME    is: <jsp:getProperty name="patientdata" property="patientName" /><br>
                        PATIENTADDRESS is: <jsp:getProperty name="patientdata" property="patientAddress" /><br>
                    </jsp:useBean>
        <%      } else {
        %>
                    <jsp:useBean id="staff" class="modal.Staff" scope="request" >
                        <h1>REGISTER SUCCESSFULLY</h1>
                        USERNAME     is: <jsp:getProperty name="staffData" property="staffUsername" /><br>
                        PASSWORD     is: <jsp:getProperty name="staffData" property="staffPassword" /><br>
                        STAFFNAME    is: <jsp:getProperty name="staffData" property="staffName" /><br>
                        STAFFADDRESS is: <jsp:getProperty name="staffData" property="staffAddress" /><br>
                    </jsp:useBean>
        <%      }
                    
            }
            String datetime = request.getParameter("date");
            out.println("<br>Date: "+datetime);

        %>
        
        <button onclick="myFunction()">Try it</button>

        <p id="demo"></p>
         
        <%@ include file="../components/Footer.jsp" %>
    </body>
    

