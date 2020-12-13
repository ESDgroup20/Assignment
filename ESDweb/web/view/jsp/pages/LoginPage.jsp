<%-- 
    Document   : index
    Created on : 10-Dec-2020, 11:38:56
    Author     : ESD20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <script src="view/js/datetime.js" type="text/javascript"></script>
        <%@ include file="../components/Header.jsp" %>
        
    </head>
  
    <body>
        <div class="d-flex justify-content-center">
            <div class="flex-column "> 
                <form action="SignInServlet" method="POST" class="d-flex flex-column align-items-center ">
                    Fast Track button:
                    <input type="submit" name="act" value="FastTrack" class="btn btn-success col-12 mb-5">         
          
                    
                    
                    <div class="form-floating mb-3">
                        <input type="text" name="us" class="form-control is-valid" id="floatingInput" placeholder="Username" >
                        <label for="floatingInput">Username</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="text" name="pw" class="form-control is-valid" id="floatingInput" placeholder="Password" />
                        <label for="floatingInput">Password</label> 
                    </div>

                    <input type="date" id="dateTimeInput" name="date" class="form-control is-invalid" id="validationServer01"/>
                    <div class="invalid-feedback mb-2">Test!</div>
                    
                    <input type="submit" name="act" value="Login" class="btn btn-primary col-12 mb-2"/>
                </form>

                <form action="SignUpServlet" method="POST" class="d-flex flex-column align-items-center">
                    <input type="submit" name="act" value="Register" class="btn btn-light col-12"/>  
                </form>  
            </div>
        </div>
            
         
    </body>
</html>
