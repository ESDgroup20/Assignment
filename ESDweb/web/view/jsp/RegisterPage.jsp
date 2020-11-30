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
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <link type="text/css" rel="stylesheet" href="view/css/address.css">
        <!--AIzaSyDlFQ_eY-ELDKYFGM8JaSro-1rAqASeikc-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDlFQ_eY-ELDKYFGM8JaSro-1rAqASeikc&libraries=places&callback=initAutocomplete"
        async defer></script>
        <script src="./view/js/address.js" type="text/javascript"></script>
        <title>Register Page</title>
    </head>
    <body>
        <form action="SignUpServlet" method="post">
            Username: <input type="text" name="us" value="" /><br>
            Password: <input type="text" name="pw" value="" /><br>
            Name: <input type="text" name="name" value="" /><br>
            Address : <input type="text" name="addr" value="" /><br>
            Role:     <select name="role">
                        <option>Patient</option>
                        <option>Doctor</option>
                        <option>Nurse</option>
                      </select> <br>
            <div id="locationField">
                <input id="autocomplete" 
                       placeholder="Enter your address"
                       onFocus="geolocate()" 
                       type="text">
                </input>
            </div>

            <table id="address">
              <tr>
                  <td class="label">Street address</td>
                  <td class="slimField">
                      <input class="field" id="street_number" disabled="true"></input>
                  </td>
                  <td class="wideField" colspan="2">
                      <input class="field" id="route" disabled="true"></input>
                  </td>
              </tr>
              <tr>
                  <td class="label">City</td>
                  <td class="wideField" colspan="3">
                      <input class="field" id="locality" disabled="true"></input>
                  </td>
              </tr>

              <tr>
                  <td class="label">State</td>
                  <td class="slimField">
                      <input class="field" id="administrative_area_level_1" disabled="true" />
                  </td>

                  <td class="label">Zip code</td>
                  <td class="wideField">
                      <input class="field" id="postal_code" disabled="true"></input>
                  </td>

              </tr>

              <tr>
                  <td class="label">Country</td>
                  <td class="wideField" colspan="3">
                      <input class="field" id="country" disabled="true"></input>
                  </td>
              </tr>
            </table>
                      
                      
            <input type="submit" name="act" value="Register" />
            <input type="submit" name="act" value="GoBack" />
            
        </form>
        
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
