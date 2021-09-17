package com.day04.ssmspring.dao;

import com.day04.ssmspring.model.Ticket;

public interface ITicketDao {
    //增加
    public void save(Ticket ticket);
    //删除 ,根据id
    public void delete(String id);
    //修改
    public void update(Ticket ticket);
    //查找，根据id查找
    public Ticket queryById(String id);
}
