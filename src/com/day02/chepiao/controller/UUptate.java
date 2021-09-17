package com.day02.chepiao.controller;

import com.day02.chepiao.dao.impl.TicketDao;
import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.service.impl.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UUptate extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数,这个页面的功能是，接收到上一个页面的id，然后查找出来，在这个页面显示
        String id = req.getParameter("id");
        //调用业务方法
        TicketService ticketService = new TicketService();
        Ticket ticket = ticketService.queryById(Integer.valueOf(id));
    //把查到的这行数据，发送到jsp页面
        req.setAttribute("ticket",ticket);

        //控制跳转,下边是请求转发，也可以使用重定向

        req.getRequestDispatcher("/WEB-INF/views/aupdate.jsp").forward(req,resp);

    }
}
