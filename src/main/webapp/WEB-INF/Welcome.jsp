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
