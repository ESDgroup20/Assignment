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
        <title>Test Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <jsp:include page="DbView.jsp" />
        
        <%-- 
              String tempStr = (String) request.getAttribute("str") ;
              out.println(tempStr);
        --%>
        
        
        <jsp:include page="Footer.jsp" />
    </body>
</html>
