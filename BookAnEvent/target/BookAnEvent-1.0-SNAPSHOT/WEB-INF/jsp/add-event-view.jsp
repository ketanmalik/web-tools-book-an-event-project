<%-- 
    Document   : add-event-view
    Created on : Apr 14, 2021, 10:21:18 AM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/font-awesome/5.15.2/css/fontawesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <script src="<%=request.getContextPath()%>/resources/js/add-event.js"></script>
        <title>Add Event</title>
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
                    <form action="event-added.htm" method="post" onsubmit="return validateAddEventForm()">
                        <div class="form-group row">
                            <label for="event-name" class="col-sm-2 col-form-label">Event Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="event-name" aria-describedby="event-name" placeholder="Enter event name">
                            </div>
                            <label for="event-cast" class="col-sm-2 col-form-label">Event Cast</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="event-cast" aria-describedby="event-cast" placeholder="Cast 1, Cast 2, Cast 3...">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="event-type" class="col-sm-2 col-form-label">Event Type</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="event-type">
                                    <option value="Movie">Movie</option>
                                    <option value="Play">Play</option>
                                    <option value="Musical">Musical</option>
                                </select>
                            </div>
                            <label for="event-rating" class="col-sm-2 col-form-label">Event Rating</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="event-rating">
                                    <option value="U">U - Unrestricted</option>
                                    <option value="U/A">U/A - Unrestricted with Caution</option>
                                    <option value="A">A - Restricted to Adults</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="event-genre" class="col-sm-2 col-form-label">Event Genre</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="event-genre">
                                    <option value="Action">Action</option>
                                    <option value="Adventure">Adventure</option>
                                    <option value="Comedy">Comedy</option>
                                    <option value="Crime">Crime</option>
                                    <option value="Fantasy">Fantasy</option>
                                    <option value="Horror">Horror</option>
                                    <option value="Mystery">Mystery</option>
                                    <option value="Romance">Romance</option>
                                    <option value="Sci-Fi">Sci-Fi</option>
                                    <option value="Thriller">Thriller</option>
                                </select>
                            </div>
                            <label for="event-language" class="col-sm-2 col-form-label">Event Language</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="event-language" aria-describedby="event-language" placeholder="Enter event language">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="event-summary" class="col-sm-2 col-form-label">Event Summary</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="5" name="event-summary" placeholder="Max 2000 characters"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="event-date" class="col-sm-2 col-form-label">Event Date</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="date" name="event-date" min={new Date().toISOString().split('T')[0]}>
                            </div>
                            <label for="event-duration" class="col-sm-2 col-form-label">Event Duration</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="event-duration" aria-describedby="event-duration" placeholder="Enter duration in minutes">
                            </div>
                        </div>
                        <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/manage-events.htm">Go Back</a>
                        &emsp;
                        <input class="btn btn-primary" type="submit" value="Add Event" />
                    </form>
                </div>
            </div>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
