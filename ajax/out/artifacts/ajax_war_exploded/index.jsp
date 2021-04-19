<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/3/25
  Time: 下午 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="./script/jquery-1.7.2.js"></script>
</head>
<body>
<script type="text/javascript">
    //一个复杂的js对象
    var stu = {
        lastName: "张三",
        age: 18,
        car: {
            pp: "宝马", price: "300"
        },
        infos: [{
            bookName: "西游记", price: 99.99
        }, 22,true]
    };
    //js对象：属性操作方便
    //alert(stu.car.pp);
    //alert(stu.infos[2]);
    //把js对象转成JSON字符串
   var strJson=JSON.stringify(stu);
  // alert(strJson);
</script>
<%=new Date()%>
<a href="getinfo">获取信息</a>
<div>
    显示信息：${msg}
</div>
</body>
<script type="text/javascript">

</script>
</html>
