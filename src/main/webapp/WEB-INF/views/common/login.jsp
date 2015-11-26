<%--
  Created by IntelliJ IDEA.
  User: tangshulei
  Date: 2015/11/26
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="<c:url value='/assets/css/static/login.css'/>">
</head>
<body>
<section class="container">
  <div class="login">
    <h1>Login to Web App</h1>
    <form method="post" action="login">
      <p>${error}</p>
      <p><input type="text" name="telephone" value="" placeholder="telephone"></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
      <%--<p class="remember_me">--%>
        <%--<label>--%>
          <%--<input type="checkbox" name="remember_me" id="remember_me">--%>
          <%--Remember me on this computer--%>
        <%--</label>--%>
      <%--</p>--%>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
  </div>

  <%--<div class="login-help">--%>
    <%--<p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>--%>
  <%--</div>--%>
</section>


</body>
</html>
