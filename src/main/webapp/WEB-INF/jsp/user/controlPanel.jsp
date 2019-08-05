<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
to jest panel kontrolny urzytkownika
<a style="background-color:cadetblue; padding: 10px 5px" href="/createEvent">create Event</a>

<c:forEach var="event" items="${events}">
    <div>${event.name} ${event.localization} ${event.eventDate} ${event.eventStatus}</div>
</c:forEach>
</body>
</html>
