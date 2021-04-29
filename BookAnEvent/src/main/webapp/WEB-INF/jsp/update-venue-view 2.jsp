<%-- 
    Document   : update-venue-view
    Created on : Apr 25, 2021, 4:04:04 PM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/font-awesome/5.15.2/css/fontawesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <!-- <script src="<%=request.getContextPath()%>/resources/js/add-event.js"></script> -->
    </script>
    <title>Update Venue</title>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand">BookAnEvent</a>
        <form action="sign-out.htm" method="post">
            <input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="Sign Out" /> 
        </form>
    </nav>
    <div class="container">
        <h3 class="form-heading">Admin's Dashboard</h3>
        <div class="card text-center">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs">
                    <li class="nav-item">
                        <form action="manage-events.htm" method="post">
                            <input class="nav-link" type="submit" class="" value="Manage Events" />
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="manage-venues.htm" method="post">
                            <input class="nav-link active" type="submit" class="" value="Manage Venues" />
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="" method="post">
                            <input class="nav-link" type="submit" class="" value="Map Events & Venues" />
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="" method="post">
                            <input class="nav-link" type="submit" class="" value="Manage Users" />
                        </form>
                    </li>
                </ul>
            </div>
            <div class="card-body text-center">
                <form:form modelAttribute="updateVenueForm" method="post" action="updated-venue.htm">
                    <div class="form-group row">
                        <form:label path="venue_name" for="venue-name" class="col-sm-2 col-form-label">Venue Name</form:label>
                            <div class="col-sm-4">
                            <form:input path="venue_name" type="text" class="form-control" name="venue-name" aria-describedby="venue-name" placeholder="Enter venue name" />
                            <form:errors path="venue_name" class="form-error" />
                        </div>
                        <form:label path="venue_city" for="venue-city" class="col-sm-2 col-form-label">Venue City</form:label>
                            <div class="col-sm-4">
                            <form:input path="venue_city" type="text" class="form-control" name="venue-city" aria-describedby="venue-city" placeholder="Enter venue city" />
                            <form:errors path="venue_city" class="form-error" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="venue_state" for="venue-type" class="col-sm-2 col-form-label">Venue State</form:label>
                            <div class="col-sm-4">
                            <form:select path="venue_state" class="form-control" name="venue-state">
                                <form:option value="Alabama">Alabama</form:option>
                                <form:option value="Alaska">Alaska</form:option>
                                <form:option value="Arizona">Arizona</form:option>
                                <form:option value="Arkansas">Arkansas</form:option>
                                <form:option value="California">California</form:option>
                                <form:option value="Colorado">Colorado</form:option>
                                <form:option value="Connecticut">Connecticut</form:option>
                                <form:option value="Delaware">Delaware</form:option>
                                <form:option value="District Of Columbia">District Of Columbia</form:option>
                                <form:option value="Florida">Florida</form:option>
                                <form:option value="Georgia">Georgia</form:option>
                                <form:option value="Hawaii">Hawaii</form:option>
                                <form:option value="Idaho">Idaho</form:option>
                                <form:option value="Illinois">Illinois</form:option>
                                <form:option value="Indiana">Indiana</form:option>
                                <form:option value="Iowa">Iowa</form:option>
                                <form:option value="Kansas">Kansas</form:option>
                                <form:option value="Kentucky">Kentucky</form:option>
                                <form:option value="Louisiana">Louisiana</form:option>
                                <form:option value="Maine">Maine</form:option>
                                <form:option value="Maryland">Maryland</form:option>
                                <form:option value="Massachusetts">Massachusetts</form:option>
                                <form:option value="Michigan">Michigan</form:option>
                                <form:option value="Minnesota">Minnesota</form:option>
                                <form:option value="Mississippi">Mississippi</form:option>
                                <form:option value="Missouri">Missouri</form:option>
                                <form:option value="Montana">Montana</form:option>
                                <form:option value="Nebraska">Nebraska</form:option>
                                <form:option value="Nevada">Nevada</form:option>
                                <form:option value="New Hampshire">New Hampshire</form:option>
                                <form:option value="New Jersey">New Jersey</form:option>
                                <form:option value="New Mexico">New Mexico</form:option>
                                <form:option value="New York">New York</form:option>
                                <form:option value="North Carolina">North Carolina</form:option>
                                <form:option value="North Dakota">North Dakota</form:option>
                                <form:option value="Ohio">Ohio</form:option>
                                <form:option value="Oklahoma">Oklahoma</form:option>
                                <form:option value="Oregon">Oregon</form:option>
                                <form:option value="Pennsylvania">Pennsylvania</form:option>
                                <form:option value="Rhode Island">Rhode Island</form:option>
                                <form:option value="South Carolina">South Carolina</form:option>
                                <form:option value="South Dakota">South Dakota</form:option>
                                <form:option value="Tennessee">Tennessee</form:option>
                                <form:option value="Texas">Texas</form:option>
                                <form:option value="Utah">Utah</form:option>
                                <form:option value="Vermont">Vermont</form:option>
                                <form:option value="Virginia">Virginia</form:option>
                                <form:option value="Washington">Washington</form:option>
                                <form:option value="West Virginia">West Virginia</form:option>
                                <form:option value="Wisconsin">Wisconsin</form:option>
                                <form:option value="Wyoming">Wyoming</form:option>
                            </form:select>
                            <form:errors path="venue_state" class="form-error" />
                        </div>
                        <form:label path="venue_country" for="venue-country" class="col-sm-2 col-form-label">Venue Country</form:label>
                            <div class="col-sm-4">
                            <form:input path="venue_country" type="text" class="form-control" name="venue-country" aria-describedby="venue-country" value="USA" readonly="true" />
                        </div>
                    </div>
                    <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/manage-venues.htm">Go Back</a>
                    &emsp;
                    <input class="btn btn-primary" type="submit" value="Update Venue" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
