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
        <form action="SignUpServlet" method="post" class="position-absolute top-50 start-50 translate-middle">
            <div class="d-flex flex-column mb-2">
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
                
                <%@ include file="../components/Address.jsp" %>
                
                <div class="form-floating mb-2">     
                    <select class="form-select mb-2" name="role" id="floatingInput">
                        <option selected >Patient</option>
                        <option>Doctor</option>
                        <option>Nurse</option>
                    </select>
                    <label class="fw-lighter" for="floatingInput">Role</label>
                </div>
            </div>
            <button class="btn btn-primary col-12" type="submit" name="act" value="SignUp">Register</button>
            
                               
            
        </form>
        
        <%@ include file="../components/Footer.jsp"%>
    </body>
</html>
