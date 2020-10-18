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
    <title>Admin</title>
</head>
<body>

<!-- Billed og hovedmenu -->
<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class =col-md-2>
        <p></p>
    </div>
    <div class =col-md-6>
        <h1><a class="one" href="FrontController?target=redirect&destination=adminpage">TobyCars</a></h1>
    </div>
    <div class =col-md-4>
        <p></p>
        <div class="btn-group" role="group" aria-label="logout" style="top:6px; left:38px">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="logoutuser">
                <button type="submit" class="btn btn-secondary">Logout</button></a>
            </form>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12" style="top:-21px;">
        <h1 class="hovedtitle">Admin Login</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-12" style="text-align: center;top:5px">
            <div>
                <p class="title">Welcome ${sessionScope.username}
                <br>Please choose a logintype</p>
            </div>
        <div class="btn-group" role="group" aria-label="Admin">
            <a class="two" href="FrontController?target=redirect&destination=admininterface">
                <button type="button" class="btn btn-secondary">Admin</button></a>
        </div>
            <div class="btn-group" role="group" aria-label="Main menu">
                <a class="two" href="FrontController?target=redirect&destination=customerpage">
                    <button type="button" class="btn btn-secondary">Customer</button></a>
            </div>
        <br>
        <br>
        <br>
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
<script src="js/buttons.js"></script>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>