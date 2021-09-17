package com.day02.chepiao.service.impl;

import com.day02.chepiao.dao.impl.TicketDao;
import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.model.fenyetiaojian;
import com.day02.chepiao.model.query;
import com.day02.chepiao.service.ITicketDao;

import java.util.List;

public class TicketService implements ITicketDao {
    @Override
    public void save(Ticket ticket) {
        TicketDao ticketDao = new TicketDao();
        ticketDao.save(ticket);
    }

    @Override
    public void delete(Integer id) {
        TicketDao ticketDao = new TicketDao();
        ticketDao.delete(id);
    }

    @Override
    public void update(Ticket ticket) {
        TicketDao ticketDao = new TicketDao();
        ticketDao.update(ticket);
    }

    @Override
    public Ticket queryById(Integer id) {
        TicketDao ticketDao = new TicketDao();
        Ticket ticket = ticketDao.queryById(id);
        return ticket;
    }

    @Override
    public List<Ticket> queryAll() {
        TicketDao ticketDao = new TicketDao();
        List<Ticket> list = ticketDao.queryAll();
        return list;
    }

    @Override
    public List<Ticket> querytiaojian(query query) {
        TicketDao ticketDao = new TicketDao();
        List<Ticket> querytiaojian = ticketDao.querytiaojian(query);
        System.out.println("这里是ticketservice的service方法="+querytiaojian);
    return querytiaojian;
}

    @Override
    public fenyetiaojian yongtiaojianchafenye(query query)
    {
        TicketDao ticketDao = new TicketDao();
        fenyetiaojian fenye = ticketDao.yongtiaojianchafenye(query);
        return fenye;
    }
}
