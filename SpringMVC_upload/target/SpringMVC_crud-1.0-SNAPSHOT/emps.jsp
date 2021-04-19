<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/3
  Time: 上午 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=new Date()%> <br>
<a href="${path}/getAllAjax">ajax获取所有员工</a> <br>
<div></div>
<script type="text/javascript">
    $("a:first").click(function () {
        $("div").empty();
        //1.发送ajax请求，获取所有员工
        $.ajax({
            url:"${path}/getAllAjax",
            type:"get",
            success:function (data) {
                $.each(data,function () {
                    var empInfo=this.lastName+"-->"+this.birth+"-->"+this.gender;
                   $("div").append(empInfo+"<br/>");
                });
            }
        });
        return false;
    });
</script>
</body>
</html>
