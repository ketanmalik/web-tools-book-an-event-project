<%-- 
    Document   : success-view
    Created on : Apr 13, 2021, 2:31:06 PM
    Author     : ketanmalik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <title>Success</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
        </nav>
        <div class="jumbotron">
            <h1 class="display-4">Success!</h1>
            <p class="lead">${requestScope.successMsg1}</p>
            <hr class="my-4">
            <p>${requestScope.successMsg2}</p>
            <p class="lead">
            <c:choose>
                <c:when test="${sessionScope.user != null && sessionScope.user.user_type == 'admin'}">
                    <a class="btn btn-primary btn-lg" href="log-in-success.htm" role="button">Go to Admin</a>
                </c:when>
                <c:when test="${sessionScope.user != null && sessionScope.user.user_type == 'customer'}">
                    <a class="btn btn-primary btn-lg" href="index.htm" role="button">Go to Customer</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary btn-lg" href="index.htm" role="button">Go to Home Page</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
</body>
</html>
