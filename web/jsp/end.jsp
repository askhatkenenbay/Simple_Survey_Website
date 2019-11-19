<%--
  Created by IntelliJ IDEA.
  User: Askhat
  Date: 20.11.2019
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The End Of Survey</title>
</head>
<body>
<h2>Your rate: ${rate}</h2>
<h2>Average rate: ${average}</h2>

<form name="logoutForm" action="controller" method="POST">
    <input type="hidden" name="command" value="logout"/>
    <button type="submit">Log Out</button>
</form>
</body>
</html>
