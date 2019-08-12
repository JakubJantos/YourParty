<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main_wrapper">

    <form method="post" action="/eventEdit/${eventEdit.id}/save"/>
    <label>Evant Name</label>
    <input type="text" name="name" value="${eventEdit.name}"/><br>
    <label>Event Localization</label>
    <input type="text" name="localization" value="${eventEdit.localization}"/>
    <label>Event Data</label>
    <input type="date" name="eventDate" value="${eventEdit.eventDate}"/>
    <label>Event Status</label>
    <select name="eventStatus">
        <option value="PRIVATE">
            PRIVATE
        </option>
        <option value="PUBLIC">
            PUBLIC
        </option>
    </select>
    <input type="submit" value="SAVE">
    </form>
</div>
</body>
</html>
