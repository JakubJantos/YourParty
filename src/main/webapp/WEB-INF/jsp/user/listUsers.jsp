<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${users}">
    <div>${user.mail} ${user.login} <a href="#">inwite</a></div>
</c:forEach>

<a style="background-color:cadetblue; padding: 10px 5px; cursor: pointer; text-decoration: none; margin-top: 20px;"
   href="/controlPanel/${user.get().id}">back</a>
</body>
</html>
