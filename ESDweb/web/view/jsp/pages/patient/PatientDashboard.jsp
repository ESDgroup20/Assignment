<%-- 
    Document   : PatientDashboard
    Created on : 15-Jan-2021, 16:59:56
    Author     : Eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <h1>Patient Page</h1>

        <form method="post" action="PatientViewController">

            <input type="submit" name="action" value="Book Appointment">
            
            <input type="submit" name="action" value="Request Refill">
       
           


        </form>
      
    
    <footer>
        <%@ include file="/view/jsp/components/Footer.jsp" %>
    </footer>
</html>
