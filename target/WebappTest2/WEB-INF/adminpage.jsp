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
        <h1><a class="one" href="#">TobyCars</a></h1>
    </div>
    <div class =col-md-4>
        <p></p>
        <div class="btn-group" role="group" aria-label="login" style="top:6px; left:20px">
            <a class="two" href="/index.jsp">
                <button type="button" class="btn btn-secondary">Logout</button></a>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12" style="top:-21px;">
        <h1 class="hovedtitle">Admin Interface</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-12" style="text-align: center">
        <p></p>
            <div class="btn-group" role="group" aria-label="Main menu">
                <a class="two" href="adminManageCars.jsp" target="_blank">
                    <button type="button" class="btn btn-secondary">Manage Cars</button></a>
            </div>
            <div class="btn-group" role="group" aria-label="FAQ">
                <button onclick="myFunction()" style="left:15px" class="btn btn-secondary">Manage Messages</button></a>
            </div>
    </div>
</div>

<div class="row">
    <div class="col-md-4">

    </div>
    <div class="col-md-4">
        <div id="myDIV" style="display:none">
            <br>
            <h3 class="title">Update Messages</h3>
            <form action="ServletGetMessages" method="post">
                <div class="form-group">
                    <select class="form-control" name="messages" id="myselect">
                        <option>Active Messages</option>
                        <option>Closed Messages</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
        </div>
    </div>
    <div class="col-md-4">

    </div>
</div>
<div class="row">
    <div class="col-md-12">
    <ul>
        <c:forEach var="message" items="${requestScope.activeCM}">
            <div class="input-group">
                <text><c:out value="${message}"/></text>
            </div>
            <br>
        </c:forEach>
    </ul>
    </div>
</div>

<script>
    function myFunction() {
        var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>

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
<!-- <script src="../buttons.js"></script> -->
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>