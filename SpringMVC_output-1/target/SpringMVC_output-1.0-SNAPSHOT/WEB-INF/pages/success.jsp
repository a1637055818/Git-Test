<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/1
  Time: 下午 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>success pages</h3>

    pageContext:${pageScope.msg};<br>
    request:${requestScope.msg};<br>
    session:${sessionScope.msg};<br>
    application:${applicationScope.msg};<br>
</body>
</html>
