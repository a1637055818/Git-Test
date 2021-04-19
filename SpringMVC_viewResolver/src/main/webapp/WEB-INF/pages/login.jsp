<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/1
  Time: 下午 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
<fmt:message key="welcomeinfo"/>
</h1>
<form action="">
    <fmt:message key="username" />：<input /><br>
    <fmt:message key="password"/>：<input /><br>
    <input type="submit" value="<fmt:message key="loginBtn"/>">
</form>
</body>
</html>
