<%-- 
    Document   : success-view
    Created on : Apr 13, 2021, 2:31:06 PM
    Author     : ketanmalik
--%>

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
                <a class="btn btn-primary btn-lg" href="index.htm" role="button">Go to home page</a>
            </p>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
