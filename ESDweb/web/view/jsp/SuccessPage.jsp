<%-- 
    Document   : LoginJSP
    Created on : 22-Nov-2020, 13:59:03
    Author     : Marken Tuan Nguyen
--%>

<%@page import="modal.Patient"%>
<%@page import="modal.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    
        <jsp:useBean id="user" class="modal.User" scope="request" />
        USERNAME is: <jsp:getProperty name="data" property="userName" /><br>
        PASSWORD is: <jsp:getProperty name="data" property="userPass" /><br>
        ROLE     is: <jsp:getProperty name="data" property="userRole" /><br>
        <% 

//            
//            switch(details.getUserRole()){
//                case "Patient":
////                    Patient patient = 
////                    out.println("<br>PATIENT NAME is:     "+);
////                    out.println("<br>PATIENT ADDRESS is:     "+);
//                    break;
//                case "Doctor":
//                case "Nurse":
////                    out.println("<br>STAFF NAME is:     "+);
////                    out.println("<br>STAFF ADDRESS is:     "+);
////                    break;
//                    
//                
//            }
            
            
            String sessionKey = (String) request.getSession().getAttribute("sessionKey");
            out.println("<br>SESSION key: "+sessionKey);
            
        %>
        
        <jsp:include page="Footer.jsp" />
    

