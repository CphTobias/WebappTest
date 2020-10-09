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
    <title>Title</title>
</head>
<body>

<p>${requestScope.welcomemessage}</p>

<p>
    <ul>
    <c:out value="Kurt"></c:out>
        <c:forEach var="car" items="{requestScope.billist}">
    <li><c:out value="${car}"/></li>
        </c:forEach>
    </ul>
</p>

</body>
</html>
