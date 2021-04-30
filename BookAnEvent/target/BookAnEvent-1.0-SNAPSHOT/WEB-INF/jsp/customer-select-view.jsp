<%-- 
    Document   : customer-select-view
    Created on : Apr 27, 2021, 1:57:26 PM
    Author     : ketanmalik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/font-awesome/5.15.2/css/fontawesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <title>BookAnEvent</title>
    </head>
    <body>
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
                    <div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <h2 style="margin: 3rem; text-align: center">
                    <span class="badge badge-secondary">Step 2</span>
                    &nbsp;
                    Select venue and time for the event <b>${sessionScope.selectedEvent}</b>
                </h2>
                <div style="margin: 1rem; text-align: center" class="table-responsive">
                    <div id="accordion">
                        <div class="card" style="width: 60%; margin-bottom: 2rem; margin-left: 20%">
                            <div id="headingOne">
                                <h5 class="mb-0">
                                    <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" style="font-size: 25px">
                                        Event Details
                                    </button>
                                </h5>
                            </div>

                            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                <div class="card-body text-dark">
                                    <p class="card-text"><b>Cast: </b>${sessionScope.requestedEvent.event_cast}</p>
                                    <div style="display: flex; justify-content: center">
                                        <p class="card-text"><b>Rating: </b>${sessionScope.requestedEvent.event_rating}</p>
                                        &nbsp;&nbsp;|&nbsp;&nbsp;
                                        <p class="card-text"><b>Genre: </b>${sessionScope.requestedEvent.event_genre}</p>
                                        &nbsp;&nbsp;|&nbsp;&nbsp;
                                        <p class="card-text"><b>Type: </b>${sessionScope.requestedEvent.event_type}</p>
                                    </div>
                                    <div style="display: flex; justify-content: center">
                                        <p class="card-text"><b>Language: </b>${sessionScope.requestedEvent.event_language}</p>
                                        &nbsp;&nbsp;|&nbsp;&nbsp;
                                        <p class="card-text"><b>Release Date: </b><fmt:formatDate value="${sessionScope.requestedEvent.event_date}" type="date" dateStyle = "long"/></p>
                                        &nbsp;&nbsp;|&nbsp;&nbsp;
                                        <p class="card-text"><b>Duration: </b>${sessionScope.requestedEvent.event_duration} mins.</p>
                                    </div>
                                    <p class="card-text"><b>Summary: </b>${sessionScope.requestedEvent.event_summary}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Venue</th>
                                <th scope="col">Event Date</th>
                                <th scope="col">Event Time</th>
                                <th scope="col">Seat Price</th>
                                <th scope="col">Seats Left</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="show" items="${sessionScope.requestedShows}">
                                <tr>
                                    <c:forEach var="venue" items="${sessionScope.venueList}">
                                        <c:set var="venueId" value="${show.venue.venue_id}" />
                                        <c:if test="${venue.venue_id == venueId}">
                                            <td>${venue.venue_name}</td>
                                            <c:set var="venue-id" scope="session" value="${venue.venue_id}" />
                                    <input type="hidden" name="venue-id" value="${venue.venue_id}" />
                                </c:if>
                            </c:forEach>
                            <td><fmt:formatDate value="${show.show_date}" type="date" dateStyle = "long"/></td>
                            <td>${show.show_time}</td>
                            <td>$${show.seat_price}</td>
                            <td>${show.seats_left}</td>
                            <td>
                                <form action="step-3.htm" method="post">
                                    <input type="submit" class="btn btn-outline-primary" value="Book" />
                                    <input type="hidden" name="show-id" value="${show.show_id}" />
                                </form>
                            </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
