<%-- 
    Document   : DbView
    Created on : 02-Dec-2020, 12:55:37
    Author     : ESD20
--%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form method="post" action="AdminViewController">

            <input type="submit" name="action" value="Accsess Users">
            <input type="submit" name="action" value="Accsess Prescriptions">
            <input type="submit" name="action" value="Accsess Appointments">
            <input type="submit" name="action" value="Acssess Invoices">
            <input type="submit" name="action" value="Handle Turnover">
            <input type="submit" name="action" value="Approve Staff">


        </form>



    </body>






</html>
