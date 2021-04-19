<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/4/1
  Time: 下午 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加页面</title>
</head>
<body>
<h1>员工添加页面</h1>
<%--表单标签
通过SpringMVC的表单标签可以实现
将模型数据中的属性和html表单元素绑定
以实现表单数据的更便捷编辑和表单值的回显
1.SpringMVC认为表单数据的每一项最终都是要回显的
    path指定的是一个属性：
    这个属性时从隐含模型(请求域中取出的某个对象中的属性)
    path指定的每一个属性，请求域中必须有一个对象拥有这个属性
        这个对象就是请求域中的command:
    modelAttribute=""
    1.以前表单标签会从请求域中获取一个command对象，
    把这个对象中的每一个属性对应的显示出来
    2.可以告诉SpringMVC不要取command的值，放了一个
    modelAttribute指定的值,取对象key就用modelAttribute指定的
--%>
<%
    pageContext.setAttribute("path",request.getContextPath() );
%>
<form:form action="${path}/emp" modelAttribute="employee" method="post">
    <%--path就是原来html中input中的name
        1.path:当做原生的name项
        2.自动回显隐含模型中某个对应的这个属性的值
    --%>
    lastName:<form:input path="lastName"/>
    <form:errors path="lastName"/>
    <br>
    email:<form:input path="email"/>
    <form:errors path="email"/>
    <br>
    gender:
    男<form:radiobutton path="gender" value="1"/>
    女<form:radiobutton path="gender" value="0"/>
    <br>
    birth:<form:input path="birth"/>
    <form:errors path="birth"/>
    <br>
    <%--items="${depts}"指定要遍历的集合
    遍历出的每一个元素是一个dept对象
    itemLabel="属性名"，指定遍历出的这个对象的哪个属性
    作为option的值
    itemValue="属性名"，指定刚才遍历出来的
    这个对象的哪个属性是作为要提交的value值--%>
    dept:
    <form:select path="department.id" items="${depts}"
        itemLabel="departmentName" itemValue="id">
    </form:select>
    <br>
    <input type="submit" value="保存"/>
</form:form>

<%--<form action="">
    lastName:<input type="text" name="lastName"/><br>
    email:<input type="text" name="email"/><br>
    gender:
    男<input type="radio" name="gender" value="1"/>
    女<input type="radio" name="gender" value="0"/><br>
    dept:<select name="department.id">
            <c:forEach items="${depts}" var="dept">
                &lt;%&ndash;标签体中的是在页面的提示选项信息，value是真正提交的值&ndash;%&gt;
                <option value="${dept.id}">${dept.departmentName}</option>
            </c:forEach>
         </select>
    <input type="submit" value="提交"/>
</form>--%>

</body>
</html>
