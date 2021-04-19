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
<a href="API">API</a>
<br>
<form action="books" method="post">
    书名：<input name="bookName" type="text"/><br>
    作者：<input name="author" type="text"/><br>
    价格：<input name="price" type="text"/><br>
    库存：<input name="stock" type="text"/><br>
    销量：<input name="sales" type="text"/><br>
    <hr>
    作者省份：<input name="address.province" type="text"/><br>
    市：<input name="address.city" type="text"/> <br>
    街道：<input name="address.street" type="text"/><br>
    <input type="submit" value="提交">
</form>
<br>
<a href="handle01?username=tomcat">username</a>
<hr>
<%--图书的增删改查请求
    使用REST风格的url地址
    /book/1 get 查询1号图书
    /book/1 put 更新一号图书
    /book/1 delete 删除一号图书
    /book post 添加图书

    从页面发起PUT\DELETE形式的请求？
    Spring提供了对Rest风格的支持
    1.SpringMVC中有一个filter，他可以把普通的请求转换为规定的请求
    配置filter HiddenHttpMethodFilter
    2.如何发其他形式请求
    按照以下要求：
    1.创建一个post类型的表单
    2.表单项中携带一个_method的参数
    3.这个_method的值就是DELETE或PUT
--%>
<a href="book/1">查询一号图书</a>
<br/>

<form action="book" method="post">
    <input type="submit" value="添加一号图书"/>
</form>
<br/>

<form action="book/1" method="post">
    <input name="_method" value="delete" hidden="hidden"/>
    <input type="submit" value="删除一号图书"/>
</form>
<br/>

<form action="book/1" method="post">
    <input name="_method" value="put" hidden="hidden"/>
    <input type="submit" value="更新一号图书"/>
</form>
<br/>
</body>
</html>
