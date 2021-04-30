<%-- 
    Document   : add-show
    Created on : Apr 26, 2021, 2:08:09 AM
    Author     : ketanmalik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form:form modelAttribute="addShowForm" method="post" action="show-added.htm">
                    <div class="form-group row">
                        <label for="event-name" class="col-sm-2 col-form-label">Event</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="event-name">
                                <c:forEach var="event" items="${sessionScope.eventList}">
                                    <option value="${event.event_id}">${event.event_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <form:label path="seat_price" for="seat-price" class="col-sm-2 col-form-label">Seat Price</form:label>
                            <div class="col-sm-4">
                            <form:input path="seat_price" type="number" class="form-control" name="seat-price" aria-describedby="seat-price" placeholder="Enter seat price" />
                            <form:errors path="seat_price" class="form-error" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="show_date" for="show-date" class="col-sm-2 col-form-label">Show Date</form:label>
                            <div class="col-sm-4">
                            <form:input path="show_date" type="date" class="form-control" name="show-date" aria-describedby="show-date" placeholder="Select show date" />
                            <form:errors path="show_date" class="form-error" />
                        </div>
                        <form:label path="show_time" for="show-time" class="col-sm-2 col-form-label">Show Time</form:label>
                            <div class="col-sm-4">
                            <form:input path="show_time" type="text" class="form-control" name="show-time" aria-describedby="show-time" placeholder="Enter show time in 12 Hrs (e.g. 09:00AM)" />
                            <form:errors path="show_time" class="form-error" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="total_rows" for="total-rows" class="col-sm-2 col-form-label">Total Rows</form:label>
                            <div class="col-sm-4">
                            <form:input path="total_rows" type="number" class="form-control" name="total-rows" aria-describedby="total-rows" placeholder="Enter total rows" />
                            <form:errors path="total_rows" class="form-error" />
                        </div>
                        <form:label path="seats_per_row" for="seats-per-row" class="col-sm-2 col-form-label">Seats per Row</form:label>
                            <div class="col-sm-4">
                            <form:input path="seats_per_row" type="number" class="form-control" name="seats-per-row" aria-describedby="seats-per-row" placeholder="Enter seats/row" />
                            <form:errors path="seats_per_row" class="form-error" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="screen" for="screen" class="col-sm-2 col-form-label">Screen / Auditorium</form:label>
                            <div class="col-sm-4">
                            <form:input path="screen" type="text" class="form-control" name="screen" aria-describedby="screen" placeholder="Enter screen/auditorium for event" />
                            <form:errors path="screen" class="form-error" />
                        </div>
                    </div>
                    <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/manage-venues.htm">Go Back</a>
                    &emsp;
                    <input class="btn btn-primary" type="submit" value="Add Show" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
