<%-- 
    Document   : log-in-view
    Created on : Apr 13, 2021, 10:20:21 AM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <script src="<%=request.getContextPath()%>/resources/js/log-in.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
        </nav>
        <div class="container">
            <h3 class="form-heading">Log In Form</h3>
            <form action="log-in-user.htm" method="post">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="text" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Password" id="pwd">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="show-password" onclick="togglePassword()">
                    <label class="form-check-label" for="show-password">Show Password</label>
                </div>
                <div id="submit-btn">
                    <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/index.htm">Go Back</a>
                    &emsp;
                    <input type="submit" class="btn btn-primary" value="Log In"/>
                </div>
            </form>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
