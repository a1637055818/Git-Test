<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/13
  Time: 下午 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>success pages</h3>
<hr>
<table cellspacing="0" cellpadding="5" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>course</th>
        <th>address</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="tea">
     <tr>
         <td>${tea.id}</td>
         <td>${tea.name}</td>
         <td>${tea.course}</td>
         <td>${tea.address}</td>
     </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="getAll?pn=1">首页</a>
            <a href="getAll?pn=${pageInfo.prePage}">上一页</a>
            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <c:if test="${num==pageInfo.pageNum}">
                    【${num}】
                </c:if>
                <c:if test="${num!=pageInfo.pageNum}">
                    <a href="getAll?pn=${num}">${num}</a>
                </c:if>
            </c:forEach>
            <a href="getAll?pn=${pageInfo.nextPage}">下一页</a>
            <a href="getAll?pn=${pageInfo.pages}">末页</a>
        </td>
    </tr>
</table>
</body>
</html>
