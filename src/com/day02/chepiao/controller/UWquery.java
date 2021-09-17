package com.day02.chepiao.controller;

import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.model.fenyetiaojian;
import com.day02.chepiao.model.query;
import com.day02.chepiao.service.impl.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UWquery")
public class UWquery extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    //接收参数
        //编号
        String id = req.getParameter("id");
        //开始车站
        String start_station = req.getParameter("start_station");
        //到达车站
        String stop_station = req.getParameter("stop_station");
        //开车时间
        String start_time = req.getParameter("start_time");
        //最低票价
        String ticket_pricea = req.getParameter("ticket_pricea");
        //最高票价
        String ticket_priceb = req.getParameter("ticket_priceb");
        //取分页的信息
        //当前页
        String currentPage = req.getParameter("currentPage");
        //每页显示条数
        String pageSize = req.getParameter("pageSize");
        //共多少条
        String totalNum = req.getParameter("totalNum");
        //共多少页
        String totalPage = req.getParameter("totalPage");
    //调用业务方法
        //把查询对象建立一个model的对象,建了一个query
        query query = new query();
        if (id!=null && !id.equals(""))
        {
            query.setId(Integer.valueOf(id));
        }
        if (start_station!=null && !start_station.equals(""))
        {
            query.setStart_station(start_station);
        }
        if (stop_station!=null && !stop_station.equals(""))
        {
            query.setStop_station(stop_station);
        }
        if (start_time!=null && !start_time.equals(""))
        {
            query.setStart_time(start_time);
        }
        if (ticket_pricea!=null && !ticket_pricea.equals(""))
        {
            query.setTicket_pricea(Integer.valueOf(ticket_pricea));
        }
        if (ticket_priceb!=null && !ticket_priceb.equals(""))
        {
            query.setTicket_priceb(Integer.valueOf(ticket_priceb));
        }
        //这是后来的，分页，当前页为空
        if (currentPage!=null && !currentPage.equals(""))
        {
            query.setCurrentPage(Integer.valueOf(currentPage));
        }
        //这是后来的，分页，每页显示条数为空
        if (pageSize!=null && !pageSize.equals(""))
        {
            query.setPageSize(Integer.valueOf(pageSize));
        }
        //然后在service建了一个按要求查找的接口，然后实现，然后调用dao，然后在dao各种写各种调用，写完了方法
        TicketService ticketService = new TicketService();
        List<Ticket> querytiaojian = ticketService.querytiaojian(query);
        //System.out.println("这里是ticketservice的querytiaojian="+querytiaojian);
        //往页面传值，这个有些忘记了，不懂了,就是这样写传值

        //后来加了一个查询分页
        //下边的这个就是分页的查询
        com.day02.chepiao.model.fenyetiaojian yongtiaojianchafenye = ticketService.yongtiaojianchafenye(query);

        //控制跳转
        //req.setAttribute("list",querytiaojian);
        req.setAttribute("query",query);
        req.setAttribute("yongtiaojianchafenye",yongtiaojianchafenye);
        req.getRequestDispatcher("/WEB-INF/views/aaa.jsp").forward(req,resp);

    }
}
