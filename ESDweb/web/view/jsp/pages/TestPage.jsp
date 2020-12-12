<%-- 
    Document   : TestJSP
    Created on : 24-Nov-2020, 12:30:04
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../components/Header.jsp" %>
        <title>Test Page</title>
    </head>
    <body>
        <%@ include file="../components/DbView.jsp" %>    
    </body>
    <footer>  
        <%@ include file="../components/Footer.jsp" %>
    </footer>
</html>
