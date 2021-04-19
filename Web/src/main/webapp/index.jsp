<%--
  Created by IntelliJ IDEA.
  User: 16370
  Date: 2021/3/28
  Time: 下午 6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
    <%
    pageContext.setAttribute("path", request.getContextPath());
    %>
</head>
<body>
<a href="ajax">ajax</a>
<div id="displaystudent"></div>
</body>
<script type="text/javascript">
    $("a[href='ajax']").click(function () {

        //项目中直接绝对路径，带项目名
        $.ajax({
            url:"${path}/ajax",
            type:"POST",
            dataType:"JSON",
            success:function (data) {
               // console.log(data);
               /* $(data).each(function () {
                    //this代表每一次正在遍历的对象
                    alert(this.lastName);
                });*/

               //(object,[callback]);
                //第一个传入要便利的数据
                //第二个回调函数
                //回调函数可以接收两个参数，
                //第一个参数代表当前遍历的元素的索引，第二个代表当前的元素
                $("#displaystudent").empty();
               $.each(data,function (index,item) {
                   //alert("当前是第个"+index+"元素"+item.age);
                   $("#displaystudent").append("<br/>学生姓名: "+item.lastName)
                       .append("<br/>学生邮箱："+item.email)
                       .append("<br/>学生年龄:"+item.age)
                       .append("<hr/>");
               });
            }
        });
        //取消默认行为
        return false;
    });
</script>
</html>
