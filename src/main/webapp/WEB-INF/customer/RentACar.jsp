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
        <h1 class="hovedtitle">Car Overview</h1>
    </div>
</div>
<!-- Title END -->

<!-- Information START -->
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-4">
        <c:forEach var="availablecars" items="${sessionScope.allavailablecars}">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="addtoorder">
                <c:out value="CarID: ${availablecars.id}"/>
                    <br><c:out value="Brand: ${availablecars.brand}"/>
                    <c:out value=" - Model: ${availablecars.model}"/>
                    <br><c:out value="Category: ${availablecars.category}"/>
                    <br><c:out value="Information:"/>
                    <br><c:out value="Build Year:  ${availablecars.buildyear}, Horsepower: ${availablecars.horsepower}, Milage ${availablecars.milage}, Weight: ${availablecars.weight}"/>
                    <br><c:out value="Price: ${availablecars.price}"/>
                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                <input type="hidden" name="carid" value="${availablecars.id}">
                    <br><button type="submit" class="btn btn-secondary">Add To Bucket</button>
            </form>
            <br>
        </c:forEach>
    </div>
    <div class="col-md-4">
        <c:forEach var="availablecarpictures" items="${sessionScope.allavailablecars}">
            <div class="container" style="position: relative;">
                <img class="d-block w-100" style="height: 38%; border:2px solid black;" src="${pageContext.request.contextPath}${availablecarpictures.imagename}" alt="${availablecarpictures.id}">
            </div>
            <br>
        </c:forEach>
    </div>
    <div class="col-md-2">

    </div>
</div>
<!-- Information END -->

<div class ="row" style="background-color: #343a40;">
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