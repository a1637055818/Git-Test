<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/3/30
  Time: 下午 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="test/admin">测试pathVariable</a> <br/>
<a href="antTest01">ant风格的URL</a> <br/>
<hr/>
<a href="hello">helloworld</a> <br/>
<a href="handle02">测试RequestMapping属性</a> <br>
<form action="handle02" method="post">
    <input type="submit"/>
</form><br>
<a href="handle03">handle03测试params</a><br>
<a href="handle04">handle04测试headers</a>

</body>
</html>
