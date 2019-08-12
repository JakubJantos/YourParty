<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script>
        function showHideEvents() {
            const eventsList = document.getElementById('eventsList');
            if (eventsList.style.visibility === "visible") {
                eventsList.style.visibility = "hidden";
            } else {
                eventsList.style.visibility = "visible";
            }
        }
    </script>
    <style>
        table, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            padding: 2px 5px;
        }
    </style>
</head>
<body>
to jest panel kontrolny urzytkownika
<a style="background-color:cadetblue; padding: 10px 5px" href="/createEvent">create Event</a>
<a style="background-color:cadetblue; padding: 10px 5px; cursor: pointer" onclick="showHideEvents();">list events</a>


<div id="eventsList" style="visibility: hidden; background-color:aquamarine; margin-top: 10px; padding: 10px;
        font-family: sans-serif; width: 420px; position: absolute; left: 341px;">
    <div style="text-align: center">
        <p>YOURS EVENTS</p>
    </div>
    <table>
        <tr>
            <th>name</th>
            <th>localization</th>
            <th>data</th>
            <th>status</th>
            <th>action</th>
        </tr>
        <c:forEach var="event" items="${eventsL}">
            <tr>
                <td>${event.name}</td>
                <td>${event.localization}</td>
                <td>${event.eventDate}</td>
                <td>${event.eventStatus}</td>
                <td><a href="/eventsEdit/${event.id}">edit</a> /
                    <a href="/Events/delete?eventId=${event.id}">delete</a><br></td>
            </tr>
        </c:forEach>

    </table>
</div>
<a style="background-color:cadetblue; padding: 10px 5px; cursor: pointer; text-decoration: none"
   href="/listUsers">found friend</a>


</body>
</html>
