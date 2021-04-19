<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/3
  Time: 上午 10:24
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
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<body>
<form action="${path}/test02" method="post">
    <input name="username"  value="tomcat"/> <br>
    <input name="password"  value="123456"/> <br>
    <input type="submit"/>
</form>
<a href="${path}/testRequestBody">ajax发送json数据</a>
</body>
<script type="text/javascript">
   $("a:eq(0)").click(function () {
       //点击发送ajax请求，请求带的数据是json
       var emp={
           lastName:"张三",
           email:"aaa@qq.com",
           gender:0
       };
       //alert(typeof emp);
       //js对象
       var empStr=JSON.stringify(emp);
       //alert(typeof  emps);
       $.ajax({
           url:"${path}/testRequestBody",
           type:"post",
           data:empStr,
           contentType:"application/json",
           success:function (data) {
                alert(data);
           }
       });
       return false;
   });
</script>
</html>
