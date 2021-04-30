<%-- 
    Document   : customer-confirm-view
    Created on : Apr 28, 2021, 8:37:07 AM
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
                    <div class="progress-bar" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <h2 style="margin: 3rem; text-align: center">
                    <span class="badge badge-secondary">Step 4</span>
                    &nbsp;
                    Booking Confirmed
                </h2>
                <div class="alert alert-success" role="alert" style="text-align: center">
                    Your booking has been confirmed. Please save your <a href="booking.pdf" target="_blank" class="alert-link">booking confirmation.</a> We hope you have a wonderful experience!
                </div>
                &emsp;
                <div style="margin-left: 35%; width: 30%">
                    <a class="btn btn-primary btn-lg" href="log-in-user.htm" role="button">Continue Booking</a>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
