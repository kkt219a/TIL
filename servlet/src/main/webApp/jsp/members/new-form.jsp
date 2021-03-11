<%--
  Created by IntelliJ IDEA.
  User: kimgyutae
  Date: 2021/03/12
  Time: 1:32 오전
  To change this template use File | Settings | File Templates.
  jsp패턴 - 3

--%>

<%--jsp 파일이라는 뜻--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/members/save.jsp" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>