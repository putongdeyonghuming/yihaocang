package com.day02.chepiao.dao;

import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.model.fenyetiaojian;
import com.day02.chepiao.model.query;

import java.util.List;

public interface ITickerDao {
    //增
    public void save(Ticket ticket);
    //删
    public void delete(Integer id);
    //改
    public void update(Ticket ticket);
    //查一个
    public Ticket queryById(Integer id);
    //查多个（用集合）多了一个list
    public List<Ticket> queryAll();
    //用条件查询，（用集合）
    public List<Ticket> querytiaojian(query query);
    //分页的查询
    public fenyetiaojian yongtiaojianchafenye(query query);
    //查询条数
    public Integer chaxuntiaoshu(query query);
}
