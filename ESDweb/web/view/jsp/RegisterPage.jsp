<%-- 
    Document   : RegisterPage
    Created on : 28-Nov-2020, 12:07:33
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <form action="SignUpServlet" method="post">
            Username: <input type="text" name="us" value="" /><br>
            Password: <input type="text" name="pw" value="" /><br>
            Name: <input type="text" name="name" value="" /><br>
            Address : <input type="text" name="addr" value="" /><br>
            Role:     <select name="role">
                        <option>Patient</option>
                        <option>Doctor</option>
                        <option>Nurse</option>
                      </select> <br>
            
            <input type="submit" name="act" value="Register" />
            <input type="submit" name="act" value="GoBack" />
            
        </form>
        
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
