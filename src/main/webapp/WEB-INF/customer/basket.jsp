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
        <h1 class="hovedtitle">Basket</h1>
    </div>
</div>
<!-- Title END -->

<c:forEach var="nomoney" items="${requestScope.paymentfailed}">
    <div class="row">
        <div class="col-md-12">
            <h4 style="text-align: center">${nomoney}</h4>
        </div>
    </div>
</c:forEach>

<!-- Information START -->
<div class="row" style="top:-25px">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">
        <table class="comonfield1" colspan="3%" align="center" width="1000">
            <tr style="font-weight:bold">
                <td><c:out value="Brand"/></td>
                <td><c:out value="Model"/></td>
                <td><c:out value="Category"/></td>
                <td><c:out value="Build Year"/></td>
                <td><c:out value="Price"/></td>
                <td><c:out value="Remove Item"/></td>
            </tr>
        <c:forEach var="bucket" items="${requestScope.allpreorders}">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="removecarid">
                <input type="hidden" name="preordercarid" value="${requestScope.preorder.carID}">
                <input type="hidden" name="preorderuserid" value="${requestScope.preorder.userID}">
                <input type="hidden" name="carid" value="${bucket.id}">
                <div style="text-align: justify">
                    <tr style="background-color: #999999; border:1px solid black">
                        <td><c:out value="${bucket.brand}"/></td>
                        <td><c:out value="${bucket.model}"/></td>
                        <td><c:out value="${bucket.category}"/></td>
                        <td><c:out value="${bucket.buildyear}"/></td>
                        <td><c:out value="${bucket.price}$"/></td>
                        <td><button type="submit" class="btn btn-secondary btn-sm">Remove Item</button></td>
                    </tr>
                </div>
            </form>
            <br>
        </c:forEach>
        </table>

        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="payorder">
            <input type="hidden" name="orderprice" value="${requestScope.orderprice}">
            <input type="hidden" name="userid" value="${requestScope.preorder.userID}">
            <input type="hidden" name="userbank" value="${sessionScope.user.bank}">
            <br>
            <h4 style="text-align: right">Price: ${requestScope.orderprice}$ - <button type="submit" class="btn btn-secondary">Purchase Order</button></h4>
            <br>
        </form>
    </div>
    <div class="col-md-2">

    </div>
</div>
<!-- Information END -->

<div class ="row" style="background-color: #343a40">
    <div class="col-md-6" style="left:15px">
        <h3 class="form-text">Contact Support</h3>
        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="contactmessage">
            <input type="hidden" name="name" id="name" value="${sessionScope.username}">
            <input type="hidden" name="email" id="email" value="${sessionScope.email}">
            <div class="form-group">
                <label class="form-text" for="InputTopic">Topic</label>
                <input type="text" name="topic" class="form-control" id="InputTopic" placeholder="Topic">
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

<jsp:include page="/WEB-INF/importbars/footer.jsp" flush="true"/>
</body>
</html>