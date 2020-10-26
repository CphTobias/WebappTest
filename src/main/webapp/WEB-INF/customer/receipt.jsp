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
        <h1 class="hovedtitle">Receipt</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <br>
        <div class="inner">
            <h3 class="title">Your Receipt for Order: ORD00${requestScope.order.id}</h3>
            <br>
            <p>Order Paid: ${requestScope.order.paid}</p>
            <p>Order Number: ORD00${requestScope.order.id}</p>
            <p>Order Date: Not yet implemented</p>
            <p>Payment Method: Server Dolors</p>
            <p>Total Amount ${requestScope.orderprice}</p>
            <br>

            <hr>

            <br>
            <h3 class="title">Order Summary</h3>
            <table class="comonfield1" colspan="3%" align="center" width="1000" style="top: -20px">
                <tr style="font-weight:bold">
                    <td><c:out value="#"/></td>
                    <td><c:out value="Product"/></td>
                    <td><c:out value="Amount"/></td>
                </tr>

                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="bucket" items="${requestScope.allpreorders}">
                    <div style="text-align: justify">
                        <tr>
                            <c:set var="count" value="${count + 1}" scope="page"/>
                            <td><c:out value="${count}"/> </td>
                            <td><c:out value="${bucket.category}: ${bucket.brand}, ${bucket.model}"/></td>
                            <td><c:out value="$${bucket.price}"/></td>
                        </tr>
                        </div>
                    <br>
                </c:forEach>

                <tr style="font-weight:bold">
                    <td><c:out value="Total Amount"/></td>
                    <td><c:out value=" "/></td>
                    <td><c:out value="$${requestScope.orderprice}"/></td>
                </tr>
            </table>
            <br>

            <hr>

            <br>
            <p>You can always see all of your orders at: "youruser" - Dropdown</p>
            <p>If you have any questions, feel free to drop a message to our support</p>
        </div>
        <br>
    </div>
    <div class="col-md-2"></div>
</div>




<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>
