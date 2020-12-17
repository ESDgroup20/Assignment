<%-- 
    Document   : AdminAppointmentView
    Created on : 16-Dec-2020, 19:20:46
    Author     : Eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/AdminSelectAppointmentController" ></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=request.getAttribute("test") %></h1>
    </body>
</html>
