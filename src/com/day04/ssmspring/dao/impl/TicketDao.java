package com.day04.ssmspring.dao.impl;

import com.day04.ssmspring.dao.ITicketDao;
import com.day04.ssmspring.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class TicketDao implements ITicketDao {
   /* @Autowired
    TicketDao ticketDao;//在测试环境里不能直接创建这个对象了，需要用@Autowired*/

    private DataSource a;//这三行是为了测试其他的，可以从xml配置文件里取到值

    public DataSource getA() {
        return a;
    }

    public void setA(DataSource a) {
        this.a = a;
    }

    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Ticket ticket) {

    }

    @Override
    public Ticket queryById(String id) {
        return null;
    }
}
