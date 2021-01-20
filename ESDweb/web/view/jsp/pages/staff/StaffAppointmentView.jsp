<%-- 
    Document   : StaffAppointmentView
    Created on : 20-Jan-2021, 01:34:56
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/StaffSelectAppointmentController" ></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><%=request.getAttribute("listOfAppointments") %></h1>
    </body>
</html>
