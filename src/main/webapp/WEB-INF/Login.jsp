<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/importbars/header.jsp" flush="true"/>
<body>


<!-- Billed og hovedmenu -->
<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/importbars/NoUserNavbar.jsp" flush="true"/>
</c:forEach>

<div class="row">
    <div class="col-md-12">
        <h1 class="hovedtitle">Login</h1>
    </div>
</div>

<c:forEach var="userbanned" items="${requestScope.userbanned}" end="0">
    <div class="row">
        <div class="col-md-12" style="text-align: center">
            <h4>${userbanned}</h4>
            <br>
        </div>
    </div>
</c:forEach>

<div class="row">
    <div class="col-md-4">
        <p></p>
    </div>
    <div class="col-md-4">
        <br>
    <form name="login" action="FrontController" method="POST">
        <input type="hidden" name="target" value="login">
        <div class="form-group">
            <label for="exampleInputUsername">Username</label>
            <input type="username" class="form-control" id="exampleInputUsername" name="username" aria-describedby="UsernameHelp" placeholder="Enter Username" required>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password" required>
        </div>
        <a class="two" target="_blank" href="FrontController?target=redirect&destination=Signup">
            <p>New user? Signup here!</p></a>
        <button type="submit" class="btn btn-secondary" value="Submit">Login</button>
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
        <br>
    </div>
</div>

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>