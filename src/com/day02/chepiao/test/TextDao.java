package com.day02.chepiao.test;

import com.day02.chepiao.dao.impl.TicketDao;
import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.model.query;
import org.junit.Test;

import java.util.List;
import java.util.Queue;

public class TextDao {
    @Test
    public void testchepiao()
    {
        TicketDao ticketDao = new TicketDao();
        Ticket ticket1 = new Ticket();
        ticket1.setStart_station("A");
        ticket1.setStop_station("B");
        ticket1.setStart_time("2021-08-22 00:00:00");
        ticket1.setTicket_price(200);
        ticketDao.save(ticket1);
    }
    @Test
    public void testshanchu()
    {
        TicketDao ticketDao = new TicketDao();

        ticketDao.delete(2);
    }
    @Test
    public void testxiugai()
    {
        TicketDao ticketDao = new TicketDao();
        Ticket ticket = new Ticket();
        ticket.setId(3);
        ticket.setTicket_price(1000);
        ticketDao.update(ticket);

    }
    @Test
    public void testchaxun()
    {
        TicketDao ticketDao = new TicketDao();

        ticketDao.queryById(3);

    }
    @Test
    public void testchaxunquanbu()
    {
        TicketDao ticketDao = new TicketDao();
        List<Ticket> tickets = ticketDao.queryAll();
        System.out.println("tickets="+tickets);
        //集合的遍历，for循环
        for(int i=0;i<tickets.size();i++)
        {
            Ticket ticket = tickets.get(i);
            System.out.println("ticket="+ticket);
        }

    }
    @Test
    public void ceshi111aaz()
    {
        TicketDao ticketDao = new TicketDao();
        query query = new query();
        query.setId(5);
        List<Ticket> querytiaojian = ticketDao.querytiaojian(query);
        System.out.println("querytiaojian="+querytiaojian);
    }

    //重写equals方法，比较字符串不能用==来比较，应该用equals
    @Test
    public void ceshibijiao()
    {
        String v1= new String("张三");
        String v2= new String("张三");
        if(v1.equals(v2))
        {
            System.out.println("相同");
        }
        else
        {
            System.out.println("不相同");
        }
    }
}
