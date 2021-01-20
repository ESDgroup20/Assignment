<%-- 
    Document   : StaffView
    Created on : 18-Dec-2020, 19:30:02
    Author     : Eli
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="StaffViewController">

            <%

//                if user is a doctor then give them the ability to refer to a specalist 
                User user = (User) request.getSession().getAttribute("userData");
                if (user.getUserRole().equals("Doctor")) {
                    out.println(
                            "<input type='submit' name='action' value='Refer To Specalist'>"
                    );
                }
            %>
            <input type="submit" name="action" value="Set Patient Prescription">
            <input type="submit" name="action" value="Approve Prescription Refill">
            <input type="submit" name="action" value="View Appointments">
            <input type="submit" name="action" value="Create Invoice">



        </form>
    </body>

    <footer>
        <%@ include file="/view/jsp/components/Footer.jsp" %>
    </footer>
</html>
