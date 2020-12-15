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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
                crossorigin="anonymous"></script>
        <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
        
    </head>
  
    <body>
        <div class="position-absolute top-50 start-50 translate-middle">
            <div class="flex-column "> 
                <form action="SignInServlet" method="POST" class="d-flex flex-column align-items-center ">
                    Fast Track button:
                    <input type="submit" name="act" value="FastTrack" class="btn btn-success col-12 mb-3">         
          
                    
                    
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
