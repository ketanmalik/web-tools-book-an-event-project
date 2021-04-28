<%-- 
    Document   : customer-details-view
    Created on : Apr 27, 2021, 5:44:39 PM
    Author     : ketanmalik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form action="sign-out.htm" method="post">
                <input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="Sign Out" /> 
            </form>
        </nav>
        <div class="container">
            <h3 class="form-heading">Book An Event</h3>
            <div class="container">
                <div class="progress" style="margin-top: 3rem">
                    <div class="progress-bar" role="progressbar" style="width: 75%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <h2 style="margin: 3rem; text-align: center">
                    <span class="badge badge-secondary">Step 3</span>
                    &nbsp;
                    Enter booking details
                </h2>
                <div class="card-body">
                    <form:form modelAttribute="bookingForm" method="post" action="step-4.htm">
                        <div class="form-group row">
                            <label for="fname" class="col-sm-2 col-form-label">First Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="fname" aria-describedby="fname" value="${sessionScope.user.fName}" readonly="true">
                            </div>
                            <label for="lname" class="col-sm-2 col-form-label">Last Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="lname" aria-describedby="fname" value="${sessionScope.user.lName}" readonly="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="email" aria-describedby="email" value="${sessionScope.user.email}" readonly="true">
                            </div>
                            <form:label path="phone" for="phone" class="col-sm-2 col-form-label">Phone Number</form:label>
                                <div class="col-sm-4">
                                <form:input path="phone" type="text" class="form-control" name="phone" aria-describedby="phone" placeholder="Enter phone number (U.S. only)" />
                                <form:errors path="phone" class="form-error" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="seats" for="seats" class="col-sm-2 col-form-label">Seats to reserve</form:label>
                                <div class="col-sm-4">
                                <form:input path="seats" type="number" min="1" class="form-control" name="seats" aria-describedby="seats" value="1" placeholder="Enter number of seats to reserve" />
                                <form:errors path="seats" class="form-error" />
                            </div>
                            <form:label path="price" for="price" class="col-sm-2 col-form-label">Total Price</form:label>
                                <div class="col-sm-4">
                                <form:input path="price" type="text" class="form-control" name="price" aria-describedby="price" placeholder="Total price" readonly="true" />
                                <form:errors path="price" class="form-error" />
                            </div>
                        </div>
                        &emsp;
                        <div style="text-align: center">
                            <input class="btn btn-primary" type="submit" value="Confirm Booking" />
                        </div>
                    </form:form>

                    <form action="step-4.htm" method="post">


                    </form>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
