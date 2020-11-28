<%-- 
    Document   : LoginJSP
    Created on : 22-Nov-2020, 13:59:03
    Author     : Marken Tuan Nguyen
--%>

<%@page import="modal.user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    
        
        <% 
//          get attribute from SignInServlet 
            User details = (User) request.getSession().getAttribute("data");
            out.println("Login Successfully");
            out.println("<br>USERNAME is: "+details.getUserName());
            out.println("<br>PASSWORD is: "+details.getUserPass());
            out.println("<br>ROLE is:     "+details.getUserRole());
            
            
            String sessionKey = (String) request.getSession().getAttribute("sessionKey");
            out.println("<br>SESSION key: "+sessionKey);
            
        %>
        
<!--      set new action Logout, called by SignOutServlet -->
        <form action="SignOutServlet">
            <input type="submit" name="act" value="Logout" />
        </form>
    

