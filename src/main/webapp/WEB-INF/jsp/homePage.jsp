<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            margin: 0px;
            padding: 0px;
            background-color: #e0e0e0;
        }
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
        h1 h3{
            font-family: sans-serif;
            text-align: center;
        }
        a{
            text-align: center;
            text-decoration: none;
            color: black;
            background-color: white;
            padding: 5px 15px;
            border: 2px solid black;
            border-radius: 15px;
            font-family: sans-serif;
        }
        a:hover{
            background-color: black;
            border-color: white;
            color: white;
        }
    </style>
</head>
<body>
<div class="main_wrapper">
    <h1>Welcom to Your party!!</h1>
    <h3>the page that yo can create your own event and invite yours friands</h3>
    <a href="/registration">Register</a>
    <a href="/login">Login</a>
</div>
</body>
</html>
