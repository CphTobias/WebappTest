<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/importbars/header.jsp" flush="true"/>
<body>


<!-- Billed og hovedmenu START -->
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/importbars/CustomerNavbar.jsp" flush="true"/>
</c:forEach>

<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/importbars/AdminNavbar.jsp" flush="true"/>
</c:forEach>
<!-- Billed og hovedmenu END -->

<div class="row">
    <div class="col-md-12">
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
    </div>
</div>

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>