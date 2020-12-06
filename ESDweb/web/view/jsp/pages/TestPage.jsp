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
        <jsp:include page="../components/Header.jsp" />
        <jsp:include page="../components/DbView.jsp" />
        
        <%-- 
              String tempStr = (String) request.getAttribute("str") ;
              out.println(tempStr);
        --%>
        
        
        <jsp:include page="../components/Footer.jsp" />
    </body>
</html>
