<%-- 
    Document   : sign-up-view
    Created on : Apr 13, 2021, 10:08:20 AM
    Author     : ketanmalik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
        <script src="<%=request.getContextPath()%>/resources/js/sign-up.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
        </nav>
        <div class="container">
            <h3 class="form-heading">Sign Up Form</h3>
            <form action="sign-up-success.htm" method="post" onsubmit="return validateSignUpForm()">
                <div class="form-group row">
                    <label for="fName" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="fName" aria-describedby="fNameHelp" placeholder="Enter first name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="lName" aria-describedby="lNameHelp" placeholder="Enter last name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email address">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" id="pwd" name="password" aria-describedby="passwordHelp" placeholder="Enter password">
                        <input class="form-check-input" type="checkbox" id="show-password" style="margin-left:1px; margin-top:11px" onclick="togglePassword()">
                        <label class="form-check-label" for="show-password" style="margin-left:20px; margin-top:5px">
                            Show Password
                        </label>
                    </div>
                    <small id="passwordRule" class="form-text text-muted">Max. 15 characters</small>
                </div>
                <div class="form-group row">
                    <label for="city" class="col-sm-2 col-form-label">City</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="city" aria-describedby="cityHelp" placeholder="Enter city">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="State" class="col-sm-2 col-form-label">State</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="state">
                            <option value="Alabama">Alabama</option>
                            <option value="Alaska">Alaska</option>
                            <option value="Arizona">Arizona</option>
                            <option value="Arkansas">Arkansas</option>
                            <option value="California">California</option>
                            <option value="Colorado">Colorado</option>
                            <option value="Connecticut">Connecticut</option>
                            <option value="Delaware">Delaware</option>
                            <option value="District Of Columbia">District Of Columbia</option>
                            <option value="Florida">Florida</option>
                            <option value="Georgia">Georgia</option>
                            <option value="Hawaii">Hawaii</option>
                            <option value="Idaho">Idaho</option>
                            <option value="Illinois">Illinois</option>
                            <option value="Indiana">Indiana</option>
                            <option value="Iowa">Iowa</option>
                            <option value="Kansas">Kansas</option>
                            <option value="Kentucky">Kentucky</option>
                            <option value="Louisiana">Louisiana</option>
                            <option value="Maine">Maine</option>
                            <option value="Maryland">Maryland</option>
                            <option value="Massachusetts">Massachusetts</option>
                            <option value="Michigan">Michigan</option>
                            <option value="Minnesota">Minnesota</option>
                            <option value="Mississippi">Mississippi</option>
                            <option value="Missouri">Missouri</option>
                            <option value="Montana">Montana</option>
                            <option value="Nebraska">Nebraska</option>
                            <option value="Nevada">Nevada</option>
                            <option value="New Hampshire">New Hampshire</option>
                            <option value="New Jersey">New Jersey</option>
                            <option value="New Mexico">New Mexico</option>
                            <option value="New York">New York</option>
                            <option value="North Carolina">North Carolina</option>
                            <option value="North Dakota">North Dakota</option>
                            <option value="Ohio">Ohio</option>
                            <option value="Oklahoma">Oklahoma</option>
                            <option value="Oregon">Oregon</option>
                            <option value="Pennsylvania">Pennsylvania</option>
                            <option value="Rhode Island">Rhode Island</option>
                            <option value="South Carolina">South Carolina</option>
                            <option value="South Dakota">South Dakota</option>
                            <option value="Tennessee">Tennessee</option>
                            <option value="Texas">Texas</option>
                            <option value="Utah">Utah</option>
                            <option value="Vermont">Vermont</option>
                            <option value="Virginia">Virginia</option>
                            <option value="Washington">Washington</option>
                            <option value="West Virginia">West Virginia</option>
                            <option value="Wisconsin">Wisconsin</option>
                            <option value="Wyoming">Wyoming</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="country" class="col-sm-2 col-form-label">Country</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="country" value="USA" readonly="">
                    </div>
                </div>
                <div id="submit-btn">
                    <a class="btn btn-warning my-2 my-sm-0" href="/BookAnEvent/index.htm">Go Back</a>
                    &emsp;
                    <input type="submit" class="btn btn-primary" value="Sign Up"/>
                </div>
            </form>
        </div>
        <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
    </body>
</html>
