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

<div class="row">
    <div class="col-md-12">
        <h1 class="hovedtitle">Frequently Asked Questions</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">General</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
        </div>
    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">Car labels</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
        </div>
    </div>
    <div class="col-md-3">
        <br>
        <p class="title" style="font-size: 30px">User information</p>
        <br>
        <div class="faq">
            <a class="two" href="cars.html"><p>Will you share any information</p></a>
            <a class="two" href="cars.html"><p>How do i make an account</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
            <a class="two" href="cars.html"><p>Tobias og Co</p></a>
            <a class="two" href="cars.html"><p>I dont know what to do</p></a>
        </div>
    </div>
    <div class="col-md-2">

    </div>
</div>

<div class ="row" style="background-color: #343a40;">
    <div class="col-md-6" style="left:15px">
        <h3 class="form-text">Contact Support</h3>
        <form action="ServletUser" method="post">
            <div class="form-group">
                <label class="form-text" for="exampleInputPassword1">Name</label>
                <input type="name" name="name" class="form-control" id="exampleInputPassword1" placeholder="Name">
            </div>
            <div class="form-group" style="top:10px">
                <label class="form-text" for="exampleInputEmail2">Email address</label>
                <input type="email" class="form-control" name="email" id="exampleInputEmail2" aria-describedby="emailHelp" placeholder="Email">
                <small id="emailHelp2" class="form-text">We'll never share your email with anyone else.</small>
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