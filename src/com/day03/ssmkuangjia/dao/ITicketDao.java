package com.day03.ssmkuangjia.dao;
import com.day03.ssmkuangjia.model.Ticket;
import java.util.List;

public interface ITicketDao {
    //增
    public void save (Ticket ticket);
    // 删
    public void delectById(Integer id);
    // 改
    public void update (Ticket ticket);
    // 查单个
    public Ticket queryById(Integer id);
    //查所有
    public List<Ticket> queryAll();
    //优化之后的方法
    public Ticket queryById1(Integer id);
    //再优化之后的方法、
    public Ticket queryById2(Integer id);
    //最终的新增方法
    public void save1(Ticket ticket);
}
