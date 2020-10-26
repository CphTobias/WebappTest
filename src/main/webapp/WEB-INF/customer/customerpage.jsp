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
        <h1 class="hovedtitle">Home</h1>
    </div>
</div>
<!-- Title END -->

<!-- Special offers START -->
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <c:forEach var="specialOffer" items="${sessionScope.specialoffer}">
                    <li data-target="#carouselExampleIndicators" data-slide-to="${specialOffer.id}"></li>
                </c:forEach>
            </ol>
            <div class="carousel-inner">
                <!-- Insert First picture here -->
                <div class="carousel-item active">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/images/Banner.jpg" alt="First slide">
                    </div>
                </div>
                <c:forEach var="specialImage" items="${sessionScope.specialcar}">
                    <div class="carousel-item">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}${specialImage.imagename}" alt="${specialImage.id}" style="height: 500px">
                            <div class="text-block"
                                 style="position: absolute;bottom: 20px;right: 20px;background-color: black;
                                 color: white;padding-left: 20px;padding-right: 20px;">
                                <h4>Offer waiting</h4>
                                <p>This is the offer</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            <br>
        </div>
    </div>
    <div class="col-md-2">

    </div>
</div>
<!-- Special offers END -->

<!-- Information START -->
<div class="row">
    <div class="col-md-3">
        <h2>Hello, ${sessionScope.username}</h2>
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