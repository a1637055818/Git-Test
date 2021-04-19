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
    <title>员工修改页面</title>
</head>
<body>
<h1>员工修改页面</h1>
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
<%--modelAttribute指定这个表单的所有内容显示绑定的是请求域中employee的值--%>
<form:form action="${path}/emp/${employee.id}" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="id" value="${employee.id}"/> <br>
    email:<form:input path="email"/> <br>
    gender:
    男<form:radiobutton path="gender" value="1"/>
    女<form:radiobutton path="gender" value="0"/> <br>
    birth:<form:input path="birth"/> <br>
    dept:<form:select path="department.id" items="${depts}"
           itemLabel="departmentName" itemValue="id">
         </form:select> <br>
    <input type="submit" value="修改">
</form:form>
</body>
</html>
