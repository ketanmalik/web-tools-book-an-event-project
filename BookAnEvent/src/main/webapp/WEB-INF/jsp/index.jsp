<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookAnEvent</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand">BookAnEvent</a>

    </nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 p-0">
                <div class="jumbotron min-vh-100 text-center m-0 d-flex flex-column justify-content-center">
                    <h1 class="display-4">Start booking your events with us!</h1>

                    <p class="lead">Browse events in your city, provide details and done!</p>
                    <p class="lead">
                    <div style="display:flex; justify-content: center">
                        <a class="btn btn-outline-success my-2 my-sm-0" href="/BookAnEvent/log-in.htm">Log In</a>
                        &emsp;
                        <a class="btn btn-outline-warning my-2 my-sm-0" href="/BookAnEvent/sign-up.htm">Sign Up</a>
                    </div>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
</body>
</html>
