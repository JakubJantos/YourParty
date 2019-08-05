<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main_wrapper {
            text-align: center;
            position: absolute;
            top: calc(50% - 150px);
            left: calc(50% - 250px);
            margin: auto;
            width: 500px;
            height: 300px;
            background-color: cadetblue;
            border: 3px solid #00ffdd;
            border-radius: 20px;
        }
        label {
            background-color: #00ffdd;
            padding: 5px 10px;
        }
    </style>
</head>
<body>

<div class="main_wrapper">
    <form method="post" action="createEvent"/>
    <label>Evant Name</label>
    <input type="text" name="name"/><br>
    <label>Event Localization</label>
    <input type="text" name="localization"/>
    <label>Event Data</label>
    <input type="date" name="eventDate"/>
    <label>Event Status</label>
    <select name="eventStatus">
        <option value="PRIVATE">
            PRIVATE
        </option>
        <option value="PUBLIC">
            PUBLIC
        </option>
    </select>
    <input type="submit" value="Create Event">
    </form>
</div>
</body>
</html>
