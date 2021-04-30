<%-- 
    Document   : customer-view
    Created on : Apr 27, 2021, 7:00:27 AM
    Author     : ketanmalik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/font-awesome/5.15.2/css/fontawesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <script src="<%=request.getContextPath()%>/resources/js/Utils.js"></script>
        <title>BookAnEvent</title>
    </head>
    <body>
        <script type="text/javascript">
            function getEventNames()
            {
                var xmlHttp = getXmlHttpObj();
                if(xmlHttp === null) {
                    alert("Couldn't load events because your browser doesn't support Ajax!");
                    return null;
                }

                xmlHttp.onreadystatechange = function ()
                {
                    if (xmlHttp.readyState === 4 & xmlHttp.status === 200)
                    {
                        var eventsInCityArr = xmlHttp.responseText.split(",");
                        var selectElement = document.getElementById("eventsInCity");
                        var options = document.querySelectorAll('#eventsInCity option');
                        options.forEach(o => o.remove());
                        for (var i = 0; i < eventsInCityArr.length; i++) {
                            selectElement.add(new Option(eventsInCityArr[i], eventsInCityArr[i]));
                        }
                        var cityError = document.getElementById("cityError");
                        if (cityError !== null) {
                            cityError.style.display = 'none';
                        }
                        var eventError = document.getElementById("eventError");
                        if (eventError !== null) {
                            eventError.style.display = 'none';
                        }
                    }
                }
                var city = document.getElementById("venueCity").value;
                xmlHttp.open("GET", "get-events.htm?city=" + city, true);
                xmlHttp.send();
            }
        </script>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
            <div style="display: flex;">
                <a class="btn btn-outline-success my-2 my-sm-0" href="/BookAnEvent/user-bookings.htm">Manage Bookings</a>
                &emsp;
                <form action="sign-out.htm" method="post">
                    <input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="Sign Out" /> 
                </form>
            </div>
        </nav>
        <div class="container">
            <h3 class="form-heading">Book An Event</h3>
            <div class="container">
                <div class="progress" style="margin-top: 3rem">
                    <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <h2 style="margin: 3rem; text-align: center">
                    <span class="badge badge-secondary">Step 1</span>
                    &nbsp;
                    Select city and event
                </h2>
                <form action="step-2.htm" method="post" name="myForm">
                    <div class="form-group">
                        <label for="city">City</label>
                        <select class="form-control" id="venueCity" name="city" onchange="getEventNames();">
                            <option value="" disabled selected hidden>Select a city</option>
                            <c:forEach var="venueCity" items="${sessionScope.venueCityList}">
                                <option value="${venueCity}">${venueCity}</option>
                            </c:forEach>
                        </select>
                        <c:if test="${sessionScope.cityError != null}">
                            <span class="form-error" id="cityError">${sessionScope.cityError}</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="event">Event</label>
                        <select class="form-control" name="event" id="eventsInCity">
                            <option value="" disabled selected hidden>Events in selected city</option>
                        </select>
                        <c:if test="${sessionScope.eventError != null}">
                            <span class="form-error" id="eventError">${sessionScope.eventError}</span>
                        </c:if>
                    </div>
                    <div id="submit-btn">
                        <input type="submit" class="btn btn-primary" value="Next"/>
                    </div>
                </form>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
