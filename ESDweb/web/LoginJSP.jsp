<%-- 
    Document   : LoginJSP
    Created on : 22-Nov-2020, 13:59:03
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <% 
            String details = (String) request.getAttribute("data") ;
            out.print(details);
        %>
    </body>
</html>
