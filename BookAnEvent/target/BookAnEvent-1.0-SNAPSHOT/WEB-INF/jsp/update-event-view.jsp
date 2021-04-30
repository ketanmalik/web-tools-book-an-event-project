<%-- 
    Document   : update-event-view
    Created on : Apr 15, 2021, 2:45:32 AM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/font-awesome/5.15.2/css/fontawesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <script src="<%=request.getContextPath()%>/resources/js/add-event.js"></script>
        <title>Update Event</title>
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
                    <form:form modelAttribute="updateEventForm" method="post" action="updated-event.htm" onsubmit="return validateAddEventForm()">
                        <div class="form-group row">
                            <form:label path="event_name" for="event-name" class="col-sm-2 col-form-label">Event Name</form:label>
                                <div class="col-sm-4">
                                <form:input path="event_name" type="text" class="form-control" name="event-name" aria-describedby="event-name" placeholder="Enter event name" />
                                <form:errors path="event_name" class="form-error" />
                            </div>
                            <form:label path="event_cast" for="event-cast" class="col-sm-2 col-form-label">Event Cast</form:label>
                                <div class="col-sm-4">
                                <form:input path="event_cast" type="text" class="form-control" name="event-cast" aria-describedby="event-cast" placeholder="Cast 1, Cast 2, Cast 3..." />
                                <form:errors path="event_cast" class="form-error" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="event_type" for="event-type" class="col-sm-2 col-form-label">Event Type</form:label>
                                <div class="col-sm-4">
                                <form:select path="event_type" class="form-control" name="event-type">
                                    <form:option value="Movie">Movie</form:option>
                                    <form:option value="Play">Play</form:option>
                                    <form:option value="Musical">Musical</form:option>
                                </form:select>
                                <form:errors path="event_type" class="form-error" />
                            </div>
                            <form:label path="event_rating" for="event-rating" class="col-sm-2 col-form-label">Event Rating</form:label>
                                <div class="col-sm-4">
                                <form:select path="event_rating" class="form-control" name="event-rating">
                                    <form:option value="U">U - Unrestricted</form:option>
                                    <form:option value="U/A">U/A - Unrestricted with Caution</form:option>
                                    <form:option value="A">A - Restricted to Adults</form:option>
                                </form:select>
                                <form:errors path="event_rating" class="form-error" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="event_genre" for="event-genre" class="col-sm-2 col-form-label">Event Genre</form:label>
                                <div class="col-sm-4">
                                <form:select path="event_genre" class="form-control" name="event-genre">
                                    <form:option value="Action">Action</form:option>
                                    <form:option value="Adventure">Adventure</form:option>
                                    <form:option value="Crime">Crime</form:option>
                                    <form:option value="Fantasy">Fantasy</form:option>
                                    <form:option value="Horror">Horror</form:option>
                                    <form:option value="Live">Live</form:option>
                                    <form:option value="Mystery">Mystery</form:option>
                                    <form:option value="Romance">Romance</form:option>
                                    <form:option value="Sci-Fi">Sci-Fi</form:option>
                                    <form:option value="Thriller">Thriller</form:option>
                                </form:select>
                                <form:errors path="event_genre" class="form-error" />
                            </div>
                            <form:label path="event_language" for="event-language" class="col-sm-2 col-form-label">Event Language</form:label>
                                <div class="col-sm-4">
                                <form:input path="event_language" type="text" class="form-control" name="event-language" aria-describedby="event-language" placeholder="Enter event language" />
                                <form:errors path="event_language" class="form-error" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="event_summary" for="event-summary" class="col-sm-2 col-form-label">Event Summary</form:label>
                                <div class="col-sm-10">
                                <form:textarea path="event_summary" class="form-control" rows="5" name="event-summary" placeholder="Max 2000 characters"></form:textarea>
                                <form:errors path="event_summary" class="form-error" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="event_date" for="event-date" class="col-sm-2 col-form-label">Event Release Date</form:label>
                                <div class="col-sm-4">
                                <form:input path="event_date" class="form-control" type="date" name="event-date" />
                                <form:errors path="event_date" class="form-error" />
                            </div>
                            <form:label path="event_duration" for="event-duration" class="col-sm-2 col-form-label">Event Duration</form:label>
                                <div class="col-sm-4">
                                <form:input path="event_duration" type="text" class="form-control" name="event-duration" aria-describedby="event-duration" placeholder="Enter duration in minutes" />
                                <form:errors path="event_duration" class="form-error" />
                            </div>
                        </div>
                        <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/manage-events.htm">Go Back</a>
                        &emsp;
                        <input class="btn btn-primary" type="submit" value="Update Event" />
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
</body>
</html>
