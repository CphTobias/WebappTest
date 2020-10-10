<%--
  Created by IntelliJ IDEA.
  User: tobia
  Date: 09-10-2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Message send!</title>
</head>
<body>

    <p>Name</p>
    <p>${requestScope.name}</p>

    <br>

    <p>Email</p>
    <p>${requestScope.email}</p>

    <br>

    <p>Message</p>
    <p>${requestScope.message}</p>

<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class="col-md-6" style="left:15px">
        <h3 class="form-text">Contact Support</h3>
        <form action="ServletGetMessages" method="post">
            <div class="form-group">
                <select class="form-control" name="messages" id="myselect">
                    <option>Active</option>
                    <option>Closed</option>
                </select>
            </div>
            <button type="submit" class="btn btn-secondary">Submit</button>
        </form>
    </div>
</div>

<ul>

    <c:forEach var="message" items="${requestScope.activeCM}">
        <div class="input-group">
            <text><c:out value="${message}"/></text>
        </div>
        <br>
    </c:forEach>
</ul>

</body>
</html>
