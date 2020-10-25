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

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/importbars/NoUserNavbar.jsp" flush="true"/>
</c:forEach>
<!-- Billed og hovedmenu END-->


<main role="main" class="container">
    <div class="content">
        <h1 class="error-status">
            <c:forEach var="error400" items="${requestScope.error400}">
                <c:out value="${error400}"/>
            </c:forEach>
        </h1>
        <p>${requestScope.error}
        </p>
    </div>
</main>

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