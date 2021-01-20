<%-- 
    Document   : DoctorReferToSpecalist
    Created on : 19-Jan-2021, 22:49:51
    Author     : Eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/DoctorSelectSpecalistController" ></jsp:include>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <form method="post" action="DoctorActionSpecalistController" >
            <%=request.getAttribute("refillsHTML")%>

        </form>
            <%=request.getAttribute("sucssesHTML")%>
        <form action="DoctorActionSpecalistController" method="get" >
  
            <%=request.getAttribute("referalsHTML")%>
        </form>

    </body>
</html>
