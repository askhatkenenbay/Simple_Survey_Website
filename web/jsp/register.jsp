<%--
  Created by IntelliJ IDEA.
  User: Askhat
  Date: 19.11.2019
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/register.css"/>
    <script src="js/register.js"></script>
</head>
<body>
<form name="registerForm" action="controller" method="POST" id="registerForm">
    <input type="hidden" name="command" value="register_user"/>
    <h1>Sign Up</h1>
    <fieldset>
        <legend><span class="number">1</span>Your basic info</legend>
        <label for="name">Name:</label>
        <input type="text" id="name" name="user_name">
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="user_email">
        <label for="password">Password:</label>
        <input type="password" id="password" name="user_password">
    </fieldset>
    <label onclick="checkNewUser()" class="button" id="submit">Sign Up</label>
</form>
</body>
</html>
