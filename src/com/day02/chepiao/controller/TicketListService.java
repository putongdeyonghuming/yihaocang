package com.day02.chepiao.controller;

import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.service.impl.TicketService;
import com.day02.chepiao.model.fenyetiaojian;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shouye")
/*查询车票列表*/
public class TicketListService extends HttpServlet
{


   // 先调用Service层的方法
    TicketService a= new TicketService();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        System.out.println("这里是aaa");
        //2.调用业务方法，
        List<Ticket> list = a.queryAll();
        //增加页码的信息，当前页，每页显示条数，共多少页等参数，设置为一个对象,然后在model里建
        //一个有关分页的参数，再从service里建方法，dao实现
        fenyetiaojian fenyetiaojian1 = new fenyetiaojian();



        req.setAttribute("list",list);
        //3.控制跳转
        req.getRequestDispatcher("/WEB-INF/views/aaa.jsp").forward(req,resp);

    }
}
