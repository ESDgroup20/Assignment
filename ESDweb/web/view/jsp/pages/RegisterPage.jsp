<%-- 
    Document   : RegisterPage
    Created on : 28-Nov-2020, 12:07:33
    Author     : ESD20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../components/Header.jsp" %>
        <title>Register Page</title>
    </head>
    <body>
        <form action="SignUpServlet" method="post" class="px-4 py-3 ">
            <div class="d-flex flex-column col-md-3 mb-2">
                <div class="form-floating mb-2">
                    <input type="text" name="us" class="form-control is-valid" id="floatingInput" placeholder="Username"/>
                    <label for="floatingInput">Username</label>
                </div>
                
                <div class="form-floating mb-2">
                    <input type="text" name="pw" class="form-control is-valid" id="floatingInput" placeholder="Password"/>
                    <label for="floatingInput">Password</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="text" name="name" class="form-control is-valid" id="floatingInput" placeholder="Name"/>
                    <label for="floatingInput">Name</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="text" name="addr" class="form-control is-invalid" id="floatingInput" placeholder="Address"/>
                    <label for="floatingInput">Address</label>
                </div>
<!--                <select class="form-select py-3" name="role">
                    <option selected >Patient</option>
                    <option>Doctor</option>
                    <option>Nurse</option>
                </select>-->
            </div>
            
            <%@ include file="../components/Address.jsp" %>
                               
            <input type="submit" name="act" value="SignUp" />
            
        </form>
        
        <%@ include file="../components/Footer.jsp"%>
    </body>
</html>
