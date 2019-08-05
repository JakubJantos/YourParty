<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${ERROR != null}">
    <div style="background-color: red;">${ERROR}</div>

</c:if>
<form method="post" action="registration">
    <label>Login: </label>
    <input type="text" name="login" />
    <label>E-mail: </label>
    <input type="email" name="mail" />
    <label>password: </label>
    <input type="password" name="password" />
    <input type="submit" value="register" />

</form>

<c:forEach var="user" items="${users}">
    <div>${user.mail} ${user.login}</div>
</c:forEach>
<c:if test="${register == true}">
    <p style="color:green;">register sukces</p>
</c:if>
</body>
</html>
