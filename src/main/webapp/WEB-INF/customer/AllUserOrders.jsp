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

<!-- Title START -->
<div class="row">
    <div class="col-md-12">
        <h1 class="hovedtitle">Orders</h1>
    </div>
</div>
<!-- Title END -->

<c:forEach var="noorders" items="${requestScope.noorders}">
<div class="row">
    <div class="col-md-12">
        <h4 style="text-align: center">${noorders}</h4>
    </div>
</div>
</c:forEach>

<div class="row">
    <div class="col-md-3">
        <br>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="orders" items="${sessionScope.orders}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <table class="comonfield1" colspan="3%" align="center" width="350" height="70">
                <tr style="font-weight:bold; font-size: 24px; padding-bottom: 30px; padding-top: 30px;
                            background-color: #999999; border:1px solid black; text-align: center">
                    <td style="top: -5px"><c:out value="${count}: ${orders.paidAt}"/></td>
                </tr>
            </table>
        </c:forEach>
    </div>
    <div class="col-md-9">
        <!-- IMPLEMENT THE CHOSEN ORDER -->
    </div>
</div>
<br>

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
