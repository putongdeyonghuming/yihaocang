package com.day02.chepiao.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addxinzeng")
public class AddTicketService extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //接收参数
        //调用业务方法
        //控制跳转,下边是请求转发，也可以使用重定向
        req.getRequestDispatcher("/WEB-INF/views/addTicket.jsp").forward(req,resp);

    }
}
