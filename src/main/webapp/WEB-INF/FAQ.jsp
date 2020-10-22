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
    <title>FAQ</title>
</head>
<body>


<!-- Billed og hovedmenu -->
<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class =col-md-1>
        <p></p>
    </div>
    <div class =col-md-7>
        <h1><a class="one" href="FrontController?target=redirect&destination=customerpage">TobyCars</a></h1>
    </div>
    <div class =col-md-4>
        <p></p>
        <div class="btn-group" role="group" aria-label="Main menu" style="top:6px;">
            <a class="two" href="FrontController?target=redirect&destination=customerpage">
                <button type="submit" class="btn btn-secondary">Home</button></a>
        </div>
        <div class="btn-group" role="group" aria-label="FAQ" style="top:6px;">
            <a class="two" target="_blank" href="FrontController?target=redirect&destination=FAQ">
                <button type="submit" style="left:20px" class="btn btn-secondary">FAQ</button></a>
        </div>
        <div class="btn-group" role="group" aria-label="login" style="top:6px; left:20px">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="logoutuser">
                <button type="submit" class="btn btn-secondary">Logout</button></a>
            </form>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12" style="top:-21px;">
        <h1 class="hovedtitle">Frequently Asked Questions</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">General</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
        </div>
    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">Car labels</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
        </div>
    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">User information</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Will you share any information</p></a>
            <a class="two" href="cars.html"><p>How do i make an account</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
        </div>
    </div>
    <div class="col-md-2">

    </div>
</div>

<div class ="row" style="background-color: rgba(29,29,29,0.91);">
    <div class="col-md-6" style="left:15px">
        <h3 class="form-text">Contact Support</h3>
        <form action="ServletUser" method="post">
            <div class="form-group">
                <label class="form-text" for="exampleInputPassword1">Name</label>
                <input type="name" name="name" class="form-control" id="exampleInputPassword1" placeholder="Name">
            </div>
            <div class="form-group" style="top:10px">
                <label class="form-text" for="exampleInputEmail2">Email address</label>
                <input type="email" class="form-control" name="email" id="exampleInputEmail2" aria-describedby="emailHelp" placeholder="Email">
                <small id="emailHelp2" class="form-text">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label class="form-text" for="exampleTextarea">Enter message</label>
                <textarea class="form-control" name="message" id="exampleTextarea" rows="3"></textarea>
            </div>
            <div class="form-group">
                <label class="form-text"for="exampleInputFile">File input</label>
                <input type="file" class="form-text" id="exampleInputFile" aria-describedby="fileHelp">
            </div>
            <button type="submit" class="btn btn-secondary">Submit</button>
        </form>
    </div>
    <div class="col-md-6">

    </div>
</div>

<footer class="page-footer font-small blue" style="background-color: rgba(29,29,29,0.91);">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3"><text style="color: #ececec">© 2020 Copyright:</text>
        <a class="one" href="cars.html">Tobias og Co |</a>
        <a class="one" href="locations.html"> EliteinsaneCars |</a>
        <a class="one" href="offers.html"> Even more elite cars </a>
    </div>
    <!-- Copyright -->

</footer>

<script type="text/javascript" src='<c:url value="/scripts/logout.js"/>'></script>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>