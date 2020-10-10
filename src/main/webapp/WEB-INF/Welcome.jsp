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
    <title>Cars</title>
</head>
<body>

<p>${requestScope.welcomemessage}</p>

<p>Dit login er ${requestScope.}</p>

<p>

<div class ="row" style="background-color: rgba(29,29,29,0.91);">
    <div class="col-md-6" style="left:15px">
        <h3 class="form-text">Contact Support</h3>
        <form action="ServletContactMessage" method="put">
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

    <c:forEach var="car" items="${requestScope.billist}">
        <div class="input-group">
            <span class="input-group-addon">
                <input type="checkbox" aria-label="Checkbox for following text input">
             </span>
                <text><c:out value="${car}"/></text>
        </div>
        <br>
    </c:forEach>
</ul>
</p>

</body>
</html>
