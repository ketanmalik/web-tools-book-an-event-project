<%-- 
    Document   : user-bookings-view
    Created on : Apr 28, 2021, 3:10:52 PM
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
    <body onload="javascript:setTimeout(hideAlert, 3000)">
        <script type="text/javascript">
            function hideAlert(){
                $(".alert").alert('close');
            }
        </script>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
            <div style="display: flex;">
                <a class="btn btn-outline-success my-2 my-sm-0" href="/BookAnEvent/log-in-user.htm">Book Events</a>
                &emsp;
                <form action="sign-out.htm" method="post">
                    <input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="Sign Out" /> 
                </form>
            </div>
        </nav>
        <div class="container">
            <h3 class="form-heading">Your Bookings</h3>
            <div style="margin: 1rem; text-align: center" class="table-responsive">
                <c:if test="${requestScope.errorMsg != null}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>${requestScope.errorMsg}</strong>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${requestScope.successMsg != null}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <strong>${requestScope.successMsg}</strong>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Event</th>
                            <th scope="col">Venue</th>
                            <th scope="col">Event Time</th>
                            <th scope="col">Date</th>
                            <th scope="col">Seats</th>
                            <th scope="col">Screen</th>
                            <th scope="col">Price</th>
                            <th scope="col">Booking Date</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="booking" items="${sessionScope.bookings}">
                            <tr>
                                <td>${booking.booking_id}</td>
                                <td>${booking.show.event.event_name}</td>
                                <td>${booking.show.venue.venue_name}</td>
                                <td>${booking.show.show_time}</td>
                                <td><fmt:formatDate value="${booking.show.show_date}" type="date" dateStyle = "long"/></td>
                                <td>${booking.seats}</td>
                                <td>${booking.show.screen}</td>
                                <td>${booking.price}</td>
                                <td><fmt:formatDate value="${booking.booking_date}" type="date" dateStyle = "long"/></td>
                                <td>
                                    <div style="display: flex; justify-content: center">
                                        <form action="cancel-booking.htm" method="post">
                                            <input type="submit" class="btn btn-outline-danger" value="Cancel" />
                                            <input type="hidden" name="cancel-booking" value="${booking.booking_id}" />
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
