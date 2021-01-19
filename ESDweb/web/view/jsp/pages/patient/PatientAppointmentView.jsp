<%-- 
    Document   : Date
    Created on : 15-Dec-2020, 20:14:31
    Author     : Marken Tuan Nguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="/PatientSelectAppointmentController" ></jsp:include>
<!DOCTYPE html>
<%
//    ArrayList<String> staffNameList = (ArrayList<String>) request.getAttribute("staffNameList");
    String staffNamePull = (String) request.getAttribute("staffNameHTML");
    if (staffNamePull == null) {
        staffNamePull = "";
    }
%>
<html>
    <div class="position-absolute top-50 start-50 translate-middle">

            
        <form action="PatientActionAppointmentController" method="post">
            <button class="btn btn-primary col-12" type="submit" name="action" value="Show Staff">Show Staff</button>
            
            <%--<%= //staffNameList%>--%>
            <%=staffNamePull%>
            
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
            <button class="btn btn-primary col-12" type="submit" name="action" value="Book">Booking</button>
        </form>
    </div>
</html>
