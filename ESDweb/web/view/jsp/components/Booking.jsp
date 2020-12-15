<%-- 
    Document   : Date
    Created on : 15-Dec-2020, 20:14:31
    Author     : Marken Tuan Nguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="position-absolute top-50 start-50 translate-middle">

     
<!--        <sql:setDataSource 
            var = "snapshot" 
            driver = "org.apache.derby.jdbc.ClientDriver"
            url = "jdbc:derby://localhost:1527/ESDweb"
            user = "root" password = "123456"/>-->
        <sql:query dataSource = "${snapshot}" var = "selectDoctor">
            SELECT staffname FROM users,staffs WHERE  users.username = staffs.UNAME AND users.role = 'Doctor'
        </sql:query>
            
        <form action="BookingServlet" method="post">
            <div class="form-floating mb-2">      
                <select class="form-select mb-2" name="doctorName" id="floatingInput">
                    <c:forEach items="${selectDoctor.rows}" var="row">
                        <option>${row.STAFFNAME}</option>
                    </c:forEach>
                </select>
                <label class="fw-lighter" for="floatingInput">Doctor</label>
            </div>
            
            <div class="form-floating mb-2">   
                <input type="date" name="date" class="form-control is-invalid" id="floatingInput"/>
                <div class="invalid-feedback mb-2">Test!</div>
                <label class="fw-lighter" for="floatingInput">Booking Date</label>
            </div>
            
            <div class="form-floating mb-2">  
                <input type="time" name="time" class="form-control is-invalid" id="floatingInput">
                <div class="invalid-feedback mb-2">Test!</div>
                <label class="fw-lighter" for="floatingInput">Booking Time</label>
            </div>
            <button class="btn btn-primary col-12" type="submit" name="act" value="Book">Booking</button>
        </form>
    </div>
</html>
