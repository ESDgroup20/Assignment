<%-- 
    Document   : StaffSetPrescriptionView
    Created on : 18-Dec-2020, 19:23:10
    Author     : Eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="/StaffSelectPrescriptionController" ></jsp:include>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action ="StaffSelectPrescriptionController"  >
            <%=request.getAttribute("patientHTML") %>
            <%=request.getAttribute("medicationHTML") %>
             <input type="submit">
        </form>
    </body>
</html>