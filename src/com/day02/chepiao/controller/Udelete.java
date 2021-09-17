package com.day02.chepiao.controller;

import com.day02.chepiao.dao.impl.TicketDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class Udelete extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String id = req.getParameter("id");
        //调用业务方法
        TicketDao ticketDao = new TicketDao();
        ticketDao.delete(Integer.valueOf(id));
        //控制跳转,下边是请求转发，也可以使用重定向
        resp.sendRedirect("/shouye");
    }
}
