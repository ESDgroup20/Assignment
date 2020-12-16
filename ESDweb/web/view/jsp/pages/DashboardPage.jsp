<%-- 
    Document   : Dashboard
    Created on : 06-Dec-2020, 01:46:22
    Author     : ESD20
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../components/Header.jsp" %>
        <title>Dashboard Page</title>
    </head>
    <body>
        
        <%
            User user = (User) request.getSession().getAttribute("userData");
            String role = user.getUserRole();
        %>
            
        <h1> Dashboard <% out.print(role); %> </h1>
            
        <%    
            if(role.equals("Admin")){
        %>      
        
                <!--admin view-->
                <%--<%@ include page="../components/DbView.jsp" >--%>
                <%@ include file="../components/AdminView.jsp" %>
        <%  }
        %>
        
    </body>
    <footer>
        <%@ include file="../components/Footer.jsp" %>
    </footer>
</html>
