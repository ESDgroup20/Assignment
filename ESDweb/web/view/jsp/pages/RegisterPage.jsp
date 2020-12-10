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
        <jsp:include page="../components/Header.jsp" />
        <title>Register Page</title>
    </head>
    <body>
        <form action="SignUpServlet" method="post" class="px-4 py-3 ">
            <div class="form-group " >
            
                <input type="text" name="us" placeholder="Username" class="form-control col-md-2 mb-2"/>
                <input type="text" name="pw" placeholder="Password" class="form-control col-md-2 mb-2"/>
                <input type="text" name="name" placeholder="Name" class="form-control col-md-2 mb-2"/>
                <input type="text" name="addr" placeholder="Address" class="form-control col-md-2 mb-2"/>
                
                <select class="form-control col-md-2" name="role">
                    <option selected >Role...</option>
                    <option>Patient</option>
                    <option>Doctor</option>
                    <option>Nurse</option>
                </select>
            </div>
            
            <jsp:include page="../components/Address.jsp" />
                               
            <input type="submit" name="act" value="SignUp" />
            
        </form>
        
        <jsp:include page="../components/Footer.jsp"/>
    </body>
</html>
