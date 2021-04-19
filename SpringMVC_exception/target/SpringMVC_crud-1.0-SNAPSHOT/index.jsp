<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/7
  Time: 下午 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
    pageContext.setAttribute("path", request.getContextPath());
    %>
</head>
<body>
<a href="${path}/handle01?i=0">test01</a> <br>
<a href="${path}/handle02?username=admin">test02</a>
</body>
</html>
