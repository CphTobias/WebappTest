<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Login</title>
</head>
<body>


<!-- Billed og hovedmenu START -->
<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class =col-md-1>
        <p></p>
    </div>
    <div class =col-md-6>
        <h1><a class="one" href="FrontController?target=redirect&destination=customerpage">TobyCars</a></h1>
    </div>
    <div class =col-md-5>
        <p></p>
        <div class="btn-group" role="group" aria-label="Main menu" style="top:6px;">
            <a class="two" href="FrontController?target=redirect&destination=customerpage">
                <button type="submit" class="btn btn-secondary">Home</button></a>
        </div>

        <div class="btn-group" role="group" aria-label="FAQ" style="top:6px;">
            <a class="two" target="_blank" href="FrontController?target=redirect&destination=FAQ">
                <button type="submit" style="left:20px" class="btn btn-secondary">FAQ</button></a>
        </div>

        <div class="btn-group" role="group" aria-label="FAQ" style="top:6px;">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="getallcars">
                <button type="submit" class="btn btn-secondary">Cars</button>
            </form>
        </div>

        <c:forEach var="adminrole" items="${sessionScope.adminrole}">
            <div class="btn-group" role="group" aria-label="adminpage" style="top:6px; left:20px">
                <a class="two" href="FrontController?target=redirect&destination=adminpage">
                    <button type="submit" class="btn btn-secondary">Admin Page</button></a>
            </div>
        </c:forEach>

        <div class="btn-group" role="group" aria-label="First group" style="top:6px; left:20px">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="getbasket">
                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                <button type="submit" class="btn btn-secondary">Basket</button>
            </form>
        </div>

        <div class="btn-group" role="group" aria-label="login" style="top:6px; left:20px">
            <button id="myBtn" class="btn btn-secondary">Logout</button>

            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <h4 class="form-text" style="text-align: center">Would you like to save your current order?</h4>
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="logoutuser">
                        <input type="hidden" name="userid" value="${sessionScope.user.id}">
                        <br>
                        <br>
                        <div style="text-align: center">
                            <button style="margin:5px;" name="logoutans" value="Yes" type="submit" class="btn btn-secondary">Yes</button>
                            <button style="margin:5px;" name="logoutans" value="No" type="submit" class="btn btn-secondary">No</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- Billed og hovedmenu END -->

<div class="row">
    <div class="col-md-12" style="top:-21px;">
        <h1 class="hovedtitle">Contact Message</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <p></p>
    </div>
    <div class="col-md-4">
        <div class="title" style="text-align: center">
            <p>Your Message Was Successful!</p>
        </div>
        <div class="form-group">
            <p style="color: #999999;">Time Sent: ${requestScope.time}
                <br>Topic: ${requestScope.topic}
                <br>Name: ${requestScope.name}
                <br>Email: ${requestScope.email}
                <br>Message:
                <br>${requestScope.message}</p>
            <a class="two" href="FrontController?target=redirect&destination=customerpage">
                <button type="button" class="btn btn-secondary">Back To Home</button></a>
        </div>
            <br>
            <br>
            <br>
    </div>
    <div class="col-md-4">

    </div>
</div>

<div class="row">
    <div class="col-md-12" style="background-color: rgba(29,29,29,0.91)">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
</div>

<footer class="page-footer font-small blue" style="background-color: rgba(29,29,29,0.91)">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3"><text style="color: #ececec">© 2020 Copyright:</text>
        <a class="one" href="cars.html">Tobias og Co |</a>
        <a class="one" href="locations.html"> EliteinsaneCars |</a>
        <a class="one" href="offers.html"> Even more elite cars </a>
    </div>
    <!-- Copyright -->

</footer>


<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>