<%-- 
    Document   : StaffAppointmentView
    Created on : 20-Jan-2021, 01:34:56
    Author     : Marken Tuan Nguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Appointment"%>
<%@page import="model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/StaffSelectAppointmentController" ></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Staff staff = (Staff) request.getSession().getAttribute("ThisStaffData");
            ArrayList<Appointment> staffAptList = (ArrayList<Appointment>) request.getSession().getAttribute("StaffAppointmentList");
        %>      
        
        <h1><%=staff.getStaffName()%>'s Appointment</h1>
        
        <form action="StaffActionAppointmentController" method="post"> 
            <table class="table table-sm table-hover table-bordered text-center">
                <thead class="table-dark "id="tableUser" data-bs-toggle="collapse" data-bs-target="#collapse1" aria-expanded="true" aria-controls="collapse1">
                    <tr>
                        <th>AppointmentID</th>
                        <th>StaffID</th>
                        <th>PatientID</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Length</th>
                    </tr>
                </thead>   

                <tbody id="collapse1" class="collapse" aria-labelledby="tableUser" >
                    <% for(Appointment apt: staffAptList){ %>
                        <tr>      
                            <td><%=apt.getAID()%></td>
                            <td><%=apt.getStaffID()%></td>
                            <td><%=apt.getPatientID()%></td>
                            <td><%=apt.getADate()%></td>
                            <td><%=apt.getATime()%></td>
                            <td><%=apt.getALength()%></td>

                        </tr>
                    <% } %>

                </tbody>
            </table>
        </form>
                    
    </body>
</html>
