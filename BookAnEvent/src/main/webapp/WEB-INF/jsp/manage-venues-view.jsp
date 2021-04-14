<%-- 
    Document   : manage-venues-view
    Created on : Apr 14, 2021, 9:43:42 AM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <!-- <script src="<%=request.getContextPath()%>/resources/js/log-in.js"></script> -->
        <title>Admin</title>
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
                <div class="card-body">
                    <h5 class="card-title">Special title treatment</h5>
                    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
