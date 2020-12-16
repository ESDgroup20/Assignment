<%-- 
    Document   : Address
    Created on : 02-Dec-2020, 16:26:26
    Author     : ESD20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <!--<link type="text/css" rel="stylesheet" href="./view/css/address.css">-->
        <!--AIzaSyBEaO3olBwKp6l8izcyoMWfxy8T0riWg6s-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEaO3olBwKp6l8izcyoMWfxy8T0riWg6s&libraries=places&callback=initAutocomplete"
        async defer></script>
        <script src="./view/js/address.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="form-floating mb-2" id="addressFramee" data-bs-toggle="collapse" data-bs-target="#addressControl" > 
            <input id="autocomplete" 
                   class="form-control is-valid "
                   placeholder="Enter your address"
                   onClick="geolocate()" 
                   type="text">
            </input>
            <label for="floatingInput">Address</label>
        </div>

        <form action="SignUpServlet" method="post">
            <table class="table table-light table-borderless collapse" id="addressControl" aria-labelledby="addressFrame">
                <tr>     
                    <td>
                        <div class="form-floating ">
                            <input class="form-control form-control-sm is-valid" 
                                   id="street_number" 
                                   placeholder="House Number"
                                   name="number"
                                   required>
                            <label for="street_number">House Number</label>
                            <div id="Feedback" class="invalid-feedback">Test!</div>

                        </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input class="form-control form-control-sm is-valid" 
                                   id="route" 
                                   placeholder="Street Name"
                                   name="route"
                                   required>
                            <label>Street Name</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td >
                        <div class="form-floating">
                            <input class="form-control form-control-sm is-valid" 
                                   id="postal_code" 
                                   placeholder="Postcode"
                                   name="postcode"
                                   required>
                            <label>Postcode</label>
                        </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input class="form-control form-control-sm is-valid" 
                                   id="locality" 
                                   placeholder="City"
                                   name="city">
                            <label>City</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td >
                        <div class="form-floating">
                            <input class="form-control form-control-sm is-valid" 
                                   id="administrative_area_level_1" 
                                   placeholder="Area"
                                   name="area">
                            <label>Area</label>
                        </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input class="form-control form-control-sm is-valid" 
                                   id="country" 
                                   placeholder="Country"
                                   name="country">
                            <label>Country</label>
                        </div>
                    </td>


                </tr>

            </table>
            
        </form>
    </body>
</html>
