<%--
  Created by IntelliJ IDEA.
  User: kimgyutae
  Date: 2021/03/12
  Time: 2:41 오전
  To change this template use File | Settings | File Templates.
  jsp패턴 - 5
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <c:forEach> 이 기능을 사용하려면 다음과 같이 선언해야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>