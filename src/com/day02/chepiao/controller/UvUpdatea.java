package com.day02.chepiao.controller;

import com.day02.chepiao.dao.impl.TicketDao;
import com.day02.chepiao.model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatea")
public class UvUpdatea extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String id = req.getParameter("id");
        //开始车站
        String start_station = req.getParameter("start_station");
        //到达车站
        String stop_station = req.getParameter("stop_station");
        //开车时间
        String start_time = req.getParameter("start_time");
        //票价
        String ticket_price = req.getParameter("ticket_price");

        //调用业务方法
        TicketDao ticketDao = new TicketDao();
        Ticket ticket = new Ticket();
        ticket.setId(Integer.valueOf(id));
        ticket.setStart_station(start_station);
        ticket.setStop_station(stop_station);
        ticket.setTicket_price(Integer.valueOf(ticket_price));
        ticket.setStart_time(start_time);
        ticketDao.update(ticket);
        //控制跳转
        resp.sendRedirect("/shouye");
    }
}
