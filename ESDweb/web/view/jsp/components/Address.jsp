<%-- 
    Document   : Address
    Created on : 02-Dec-2020, 16:26:26
    Author     : Marken Tuan Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <link type="text/css" rel="stylesheet" href="./view/css/address.css">
        <!--AIzaSyBEaO3olBwKp6l8izcyoMWfxy8T0riWg6s-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEaO3olBwKp6l8izcyoMWfxy8T0riWg6s&libraries=places&callback=initAutocomplete"
        async defer></script>
        <script src="./view/js/address.js" type="text/javascript"></script>
    </head>
    <body>
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
    </body>
</html>
