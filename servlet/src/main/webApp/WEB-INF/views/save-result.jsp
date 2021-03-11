<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kimgyutae
  Date: 2021/03/12
  Time: 2:40 오전
  To change this template use File | Settings | File Templates.
  jsp패턴 - 5
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body> 성공
<ul>
    <%--
        원래대로면 아래처럼 사용하지만 ${}를 사용하면 더 간편하게 표현할 수 있다.
        <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    --%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>