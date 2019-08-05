<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <form method="post" action="login">
            <label>login</label>
            <input type="text" name="login"/>
            <label>password</label>
            <input type="password" name="password"/>
            <input type="submit" value="Login"/>
        </form>
        <c:if test="${badLogin != null}">
            <div style="background-color: red;">${badLogin}</div>

        </c:if>

    </body>
</html>
