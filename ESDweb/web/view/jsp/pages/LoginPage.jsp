<%-- 
    Document   : index
    Created on : 10-Dec-2020, 11:38:56
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <script src="view/js/datetime.js" type="text/javascript"></script>
    </head>
  
    <body>
        <jsp:include page="../components/Header.jsp" />
        <form action="SignInServlet" method="POST" class="px-4 py-3">
            
            Fast Track button: <br>
            <input type="submit" name="act" value="FastTrack">         
            <br><br><br>
            
            <div class="col-md-4 mb-3">
                <input type="text" name="us" class="form-control is-valid" id="validationServer01" placeholder="Username" />
                <div class="valid-feedback">Looks good!</div>
            
                <input type="text" name="pw" class="form-control is-valid" id="validationServer01" placeholder="Password" />
                <div class="valid-feedback">Looks good!</div>
                
                <input type="date" id="dateTimeInput" name="date" class="form-control is-invalid" id="validationServer01"/>
                <div class="invalid-feedback">Test!</div>
            </div>
                
                
            
            
            <input type="submit" name="act" value="Login" class="btn btn-primary col-md-4"/>
        </form>
        
        <form action="SignUpServlet" method="POST"class="px-4">
            <input type="submit" name="act" value="Register" class="btn btn-light col-md-4"/>  
        </form>      
         
    </body>
</html>
