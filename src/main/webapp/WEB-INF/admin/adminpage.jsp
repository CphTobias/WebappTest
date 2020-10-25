<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/importbars/header.jsp" flush="true"/>
<body>

<!-- Billed og hovedmenu -->
<jsp:include page="/WEB-INF/importbars/AdminpageNavbar.jsp" flush="true"/>


<div class="row">
    <div class="col-md-12">
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
        <br>
        <br>
        <br>
    </div>
</div>

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>