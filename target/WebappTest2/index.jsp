<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/importbars/header.jsp" flush="true"/>
<body>

<%
    if (request.getServletContext().getAttribute("notloggedin") == null) {
        request.getServletContext().setAttribute("notloggedin", "notloggedin");
    }
%>

<!-- Billed og hovedmenu -->
<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/importbars/NoUserNavbar.jsp" flush="true"/>
</c:forEach>
<!-- Billed og hovedmenu -->

<div class="row">
    <div class="col-md-12">
        <h1 class="hovedtitle">Home</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-3">
        <h2>Hello, world!</h2>
    </div>
    <div class="col-md-3">
        <h2>Hello, world!</h2>
        <p>Hej med dig dette er en test</p>
    </div>
    <div class="col-md-6">
        <h2>Hello, world!</h2>
        <p>Hej med dig dette er en test igen igen igen igen igen igen igen</p>
        <p class="title">Tester igen</p>
    </div>
</div>

<div class ="row" style="background-color: rgba(29,29,29,0.91);">
    <div class="col-md-6" style="left:15px">

    </div>
    <div class="col-md-6">

    </div>
</div>

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>