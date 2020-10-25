<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/importbars/header.jsp" flush="true"/>
<body>


<!-- Billed og hovedmenu -->
<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/importbars/NoUserNavbar.jsp" flush="true"/>
</c:forEach>

<div class="row">
    <div class="col-md-12">
        <h1 class="hovedtitle">Signup</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <p></p>
    </div>
    <div class="col-md-4">
        <br>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="target" value="register">
            <div class="form-group">
                <label for="exampleInputUsername">Username</label>
                <input type="username" class="form-control" id="exampleInputUsername" name="username" aria-describedby="UsernameHelp" placeholder="Enter Username">
            </div>
            <div class="form-group">
                <label for="InputEmail">Email</label>
                <input type="text" class="form-control" id="InputEmail" name="email" aria-describedby="EmailHelp" placeholder="Enter Email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="password1" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword2">Repeat Password</label>
                <input type="password" class="form-control" id="exampleInputPassword2" name="password2" placeholder="Repeat Password">
            </div>
            <button type="submit" class="btn btn-secondary" value="Submit">Signup</button>
            <br>
            <br>
            <br>
        </form>
    </div>
    <div class="col-md-4">

    </div>
</div>

<div class="row">
    <div class="col-md-12" style="background-color: #343a40">
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

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>