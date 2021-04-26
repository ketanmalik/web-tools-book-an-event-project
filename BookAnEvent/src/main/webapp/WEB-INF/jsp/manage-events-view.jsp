<%-- 
    Document   : admin-view
    Created on : Apr 14, 2021, 9:09:54 AM
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
                                <input class="nav-link active" type="submit" class="" value="Manage Events" />
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="manage-venues.htm" method="post">
                                <input class="nav-link" type="submit" class="" value="Manage Venues" />
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
                    <form action="add-event.htm" method="post">
                        <input class="btn btn-primary" type="submit" value="Add an Event" />
                    </form>
                    <div style="margin:1rem">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Event ID</th>
                                    <th scope="col">Event Name</th>
                                    <th scope="col">Event Type</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="event" items="${sessionScope.eventList}">
                                    <tr>
                                        <td>${event.event_id}</td>
                                        <td>${event.event_name}</td>
                                        <td>${event.event_type}</td>
                                        <td>
                                            <div style="display: flex; justify-content: center">
                                                <form action="delete-event.htm" method="post">
                                                    <input type="submit" class="btn btn-outline-danger" value="Delete" />
                                                    <input type="hidden" name="delete-event" value="${event.event_id}" />
                                                </form>
                                                &emsp;
                                                <form action="update-event.htm" method="post">
                                                    <input type="submit" class="btn btn-outline-primary" value="View / Update" />
                                                    <input type="hidden" name="update-event" value="${event.event_id}" />
                                                </form>
                                            </div>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
