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
<a href="hello">test hello</a> <br>
<hr>
<%--
1.文件上传：
    1.文件上传表单准备：enctype="multipart/form-data"
    2.导入fileupload
        commons-fileupload-1.2.1.jar
        commons-io.2.0.1.jar
    3.javaweb:
        new FileItemDiskFactory()...
    3.只要在SpringMVC配置文件中，编写一个配置
    配置一个文件上传解析器（MultipartResolver）
    4.文件上传处理
        在处理器方法上写一个
        @RequestParam("headerimg") MultipartFile file
        封装了当前文件的信息，可以直接保存
--%>
${msg}
<form action="${path}/uploads" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerimg"/> <br>
    用户头像：<input type="file" name="headerimg"/> <br>
    用户头像：<input type="file" name="headerimg"/> <br>
    用户头像：<input type="file" name="headerimg"/> <br>
    用户名：<input type="text" name="username"/> <br>
    <input type="submit">
</form>
<hr>
<form action="${path}/upload" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerimg"/> <br>
    用户名：<input type="text" name="username"/> <br>
    <input type="submit">
</form>
</body>
</html>
