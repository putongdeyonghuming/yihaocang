<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/9/1
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"  %>
<html>
<head>
    <title>新增</title>
</head>
<body>
这里是添加页面
<form action="/addxinzenga" method="post">
        开始车站:<input id="start_station" name="start_station" value=""/>
        <br/>
        <br/>
        到达车站:<input id="stop_station" name="stop_station" value=""/>
        <br/>
        <br/>
    开车时间:<input id="start_time" name="start_time" value=""/>
    <br/>
    <br/>
    票价:<input id="ticket_price" name="ticket_price" value=""/>
    <br/>
    <br/>
        <input type="submit" value="保存">
</form>
<div align=center>
    <a href= "/shouye" >点击这里跳转回首页</a>
</div>
</body>
</html>
