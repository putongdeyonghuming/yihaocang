<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/9/1
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"  %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
这里是修改页面
<form action="/updatea" method="post">
    编号:<input id="id" name="id" value="${ticket.id}"/>
    <br/>
    开始车站:<input id="start_station" name="start_station" value="${ticket.start_station}"/>
    <br/>
    <br/>
    到达车站:<input id="stop_station" name="stop_station" value="${ticket.stop_station}"/>
    <br/>
    <br/>
    开车时间:<input id="start_time" name="start_time" value="${ticket.start_time}"/>
    <br/>
    <br/>
    票价:<input id="ticket_price" name="ticket_price" value="${ticket.ticket_price}"/>
    <br/>
    <br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
