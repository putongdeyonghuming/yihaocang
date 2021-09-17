<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/static/hi.js"></script>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/8/30
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%--上边加上UTF-8--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<html>
<head>
  <title>车票编码页面</title>
  如果这里写一个js,那么页面加载完后就会执行这个js方法，弹窗,js函数也能外置写在，web里
  <script type="text/javascript">
    function a()
    {
      alert("这里是刚进入页面显示的弹窗")
    }
    a();
    //调用上边的另一个文件里的外置js方法
    c();
    var num = bijiao(3,9);
    alert("两个数相减的值是"+num)
  </script>
</head>
<body>
这里是车票编码页面 获取的参数,${list}<br>
<table align="center" border="1">
  <tr align="center">
    <td align="center">编号 </td>
    <td align="center">开始地区</td>
    <td align="center">到达地区</td>
    <td align="center">开车时间</td>
    <td align="center">票价</td>
    <td align="center">操作</td>
  </tr>
  <tr>
    <td>${list[0].id}</td>
    <td>${list[0].start_station}</td>
    <td>${list[0].stop_station}</td>
    <td>${list[0].start_time}</td>
    <td>${list[0].ticket_price}</td>
  </tr>
<c:forEach items="${yongtiaojianchafenye.data}" var="ticket">
  <tr>
    <td>${ticket.id}</td>
    <td>${ticket.start_station}</td>
    <td>${ticket.stop_station}</td>
    <td>${ticket.start_time}</td>
    <td>${ticket.ticket_price}</td>
      <td>
        <a href="/delete?id=${ticket.id}"> 删除 </a>|
        <a href="/update?id=${ticket.id}"> 修改 </a>
      </td>
  </tr>
</c:forEach>
</table>
<div align=center>
  <a href= "/addxinzeng" >点击这里跳转到新增页面4</a>
</div>

<div>下边是条件查询</div>
<div align=center>
<form action="/UWquery" method="post">
  车票编号:<input id="id" name="id" value=""/>
  <br/>
  <br/>
  开始车站:<input id="start_station" name="start_station" value="${query.start_station}"/>
  <br/>
  <br/>
  到达车站:<input id="stop_station" name="stop_station" value="${query.stop_station}"/>
  <br/>
  <br/>
  开车时间:<input id="start_time" name="start_time" value="${query.start_time}"/>
  <br/>
  <br/>
  最低票价:<input id="ticket_pricea" name="ticket_pricea" value="${query.ticket_pricea}"/>
  <br/>
  <br/>
  最高票价:<input id="ticket_priceb" name="ticket_priceb" value="${query.ticket_priceb}"/>
  <br/>
  <br/>
  <input type="submit" value="查询">
  <br/>
  <br/>
  当前页:<input id="currentPage" name="currentPage" value="1">
  每页显示条数<input id="pageSize" name="pageSize" value="3">
  <td>
    <tr>
      <a href="#" onclick="gopage();">首页</a>
      <a href="#" onclick="gopage(${yongtiaojianchafenye.currentPage}-1);">上一页</a>
      <a href="#" onclick="gopage(${yongtiaojianchafenye.currentPage}+1);">下一页</a>
      <a href="#" onclick="gopage(${yongtiaojianchafenye.totalNum});">尾页</a>
      每页显示${yongtiaojianchafenye.pageSize}条，当前${yongtiaojianchafenye.currentPage}/${yongtiaojianchafenye.totalPage}页，共${yongtiaojianchafenye.totalNum}条数据
    </tr>
  </td>
</form>
</div>
</body>
<%--定义函数--%><%--/*向页面弹窗,上边点击上一页有语句,可以用来提交表单*/--%>
<script type="text/javascript">
function gopage(currentPage)//直接写参数，不用类型，如果有返回值，直接写rutern
{
 alert("------这是第一个js函数--------");
 //为了防止页码出现负数，写一个if
  if(currentPage<1)
  {
    currentPage=1;
  }
 //点击之后给当前页赋值
  document.getElementById("currentPage").value=currentPage
 //提交表单
 document.forms[0].submit();
}

</script>
</html>
