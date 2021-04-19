<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/1
  Time: 下午 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<head>
    <title>员工列表页面</title>
    <script type="text/javascript" src="${path}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>

<h1>员工列表</h1>
<c:if test="${empty emps}">
    <h3>没有任何员工信息！请添加员工信息！</h3>
</c:if>
<c:if test="${!empty emps}">
<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>birth</th>
        <th>departmentName</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

       <c:forEach items="${emps}" var="emp">
           <tr>
               <td>${emp.id}</td>
               <td>${emp.lastName}</td>
               <td>${emp.email}</td>
               <td>${emp.gender==0?"女":"男"}</td>
               <td>${emp.birth}</td>
               <td>${emp.department.departmentName}</td>
               <td>
                   <a href="${path}/emp/${emp.id}">Edit</a>
               </td>
               <td>
                   <a href="${path}/emp/${emp.id}" class="delBtn">Delete</a>
               </td>
           </tr>
       </c:forEach>

</table>
    <br>
</c:if>
<br>
<a href="${path}/toAddPage">添加员工</a>

<form id="deleteForm" action="${path}/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
<script type="text/javascript">
    $(function () {
        $(".delBtn").click(function () {
            //1.改变表单的action指向
            $("#deleteForm").attr("action",this.href);
            //2.提交表单
            $("#deleteForm").submit();
            return false;
        });
    });
</script>
</body>
</html>
