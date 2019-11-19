<%--
  Created by IntelliJ IDEA.
  User: Askhat
  Date: 19.11.2019
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/login.js"></script>
</head>
<body>
<div id="login-form-center">
    <form name="login-form" method="POST" action="controller" id="loginForm">
        <input type="hidden" name="command" value="login"/>
        <h2>Survey Pro2</h2>
        <div class="box">
            <input class="username" name="login" id="login" type="text" placeholder="User Name">
            <input class="username" name="password" type="password" placeholder="Password" id="password">
            <label onclick="checkInput()" class="button">Log in</label>
        </div>
    </form>
    <form name="register-form" method="POST" action="controller" id="register-form">
        <input type="hidden" name="command" value="register"/>
        <p>Not registered? <input value="Create an account" class="fpwd" id="signup" type="submit"/>
        </p>
    </form>
</div>
</body>
</html>
