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
        <script src="<%=request.getContextPath()%>/resources/js/Utils.js"></script>
    </head>
    <body>

        <script type="text/javascript">
            function checkLoginDetails() {
                var xmlHttp = getXmlHttpObj();
                if (xmlHttp === null) {
                    alert("Couldn't verify details because your browser doesn't support Ajax!");
                    return null;
                }
                var email = document.getElementById("email").value;
                var password = document.getElementById("password").value;
                var invalidUserError = document.getElementById("invalid-user");

                xmlHttp.open("POST", "validate-user.htm", false);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send("email=" + email + "&password=" + password);
                if (xmlHttp.readyState === 4)
                {
                    if (xmlHttp.status === 200) {
                        if (xmlHttp.responseText === "validUser") {
                            return true;
                        } else {
                            invalidUserError.style.display = 'block';
                            return false;
                        }
                    } else {
                        invalidUserError.style.display = 'block';
                        return false;
                    }
                }
            }
        </script>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">BookAnEvent</a>
        </nav>
        <div class="container">
            <h3 class="form-heading">Log In Form</h3>
            <div id="invalid-user" class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none">
                <strong>Either email or password is incorrect. Please check your details and try again.</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="log-in-user.htm" method="post" onsubmit="return checkLoginDetails()">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="text" id="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" class="form-control" name="password" placeholder="Password" id="pwd">
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
