package com.day03.ssmkuangjia.test;

import com.day03.ssmkuangjia.dao.impl.TickectDao;
import com.day03.ssmkuangjia.model.Ticket;
import org.junit.Test;

import java.util.List;

public class TESTDAO
{
    @Test
    public void TESTddaao()
    {
        TickectDao tickectDao = new TickectDao();
        Ticket ticket = tickectDao.queryById(5);
        String s = ticket.toString();

        System.out.println(s);
    }
    @Test
    public void TESTdd ()
    {
        TickectDao tickectDao = new TickectDao();
        Ticket ticket1 = new Ticket();
        ticket1.setStart_station("1号");
        ticket1.setStop_station("lis1");
        tickectDao.save(ticket1);
        tickectDao.delectById(3);
    }
    @Test
    public void TESTdd1()
    {
        TickectDao tickectDao = new TickectDao();
        Ticket ticket1 = new Ticket();
        ticket1.setStart_station("1号");
        ticket1.setStop_station("lis1");
        ticket1.setId(12);
        tickectDao.update(ticket1);
    }
    @Test
    public void TESTchaxun1()
    {
        TickectDao tickectDao = new TickectDao();
        List<Ticket> list = tickectDao.queryAll();
        System.out.println("list="+list);
    }
    @Test
    public void TESTdd2()
    {
        TickectDao tickectDao = new TickectDao();
        Ticket ticket1 = new Ticket();
        ticket1.setStart_station("1号");
        ticket1.setStop_station("lis1");
        ticket1.setId(12);
        tickectDao.save1(ticket1);
    }
}

