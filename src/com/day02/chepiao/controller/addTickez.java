package com.day02.chepiao.controller;

import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.service.impl.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addxinzenga")
public class addTickez extends HttpServlet
{
    //这个是把页面输入的值存到哪里

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //接收参数
            //开始车站
        String start_station = req.getParameter("start_station");
            //到达车站
        String stop_station = req.getParameter("stop_station");
        //开车时间
        String start_time = req.getParameter("start_time");
        //票价
        String ticket_price = req.getParameter("ticket_price");


        //调用业务方法
        TicketService ticketService = new TicketService();
        Ticket ticket = new Ticket();
        ticket.setStart_station(start_station);
        ticket.setStop_station(stop_station);
        ticket.setStart_time(start_time);
        ticket.setTicket_price(Integer.valueOf(ticket_price));
        ticketService.save(ticket);
        //控制跳转
        //req.getRequestDispatcher("/WEB-INF/views/addTicket.jsp").forward(req,resp);
        resp.sendRedirect("/shouye");

    }
}
