package com.day02.chepiao.dao.impl;

import com.day02.chepiao.dao.ITickerDao;
import com.day02.chepiao.model.Ticket;
import com.day02.chepiao.model.fenyetiaojian;
import com.day02.chepiao.model.query;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao implements ITickerDao {
    @Override
    public void save(Ticket ticket) {
        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "INSERT INTO ticket (start_station,stop_station,start_time,ticket_price) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                System.out.println("语句编写完成");
                //设置参数
                preparedStatement.setString(1,ticket.getStart_station());
                preparedStatement.setString(2,ticket.getStop_station());
                preparedStatement.setString(3,ticket.getStart_time());
                preparedStatement.setInt(4,ticket.getTicket_price());
                //4.执行
                preparedStatement.executeUpdate();
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }


    }

    @Override
    public void delete(Integer id) {//1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "DELETE FROM ticket where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                System.out.println("语句编写完成");
                //设置参数
                preparedStatement.setInt(1,id);
                //4.执行
                preparedStatement.executeUpdate();
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }
    }
    @Override
    public void update(Ticket ticket)
    {
        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "update ticket SET start_station=?,stop_station=?,start_time=?,ticket_price =? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                System.out.println("语句编写完成");
                //设置参数
                preparedStatement.setString(1,ticket.getStart_station());
                preparedStatement.setString(2,ticket.getStop_station());
                preparedStatement.setString(3,ticket.getStart_time());
                preparedStatement.setInt(4,ticket.getTicket_price());
                preparedStatement.setInt(5,ticket.getId());
                //4.执行
                preparedStatement.executeUpdate();
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }


    }

    @Override
    public Ticket queryById(Integer id)
    {
        Ticket ticket = new Ticket();
        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "select id,start_station,stop_station,start_time,ticket_price from ticket  where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                System.out.println("语句编写完成");
                //设置参数
                preparedStatement.setInt(1,id);

                //4.执行
                ResultSet resultSet = preparedStatement.executeQuery();
                //解析结果集
                while (resultSet.next())
                {   //取 id
                    int id1 = resultSet.getInt("id");
                    //取开始车站
                    String start_station = resultSet.getString("start_station");
                    //取到达车站
                    String stop_station = resultSet.getString("stop_station");
                    //发车时间
                    String start_time = resultSet.getString("start_time");
                    //票价
                    int ticket_price = resultSet.getInt("ticket_price");
                    //封装到对象里边去
                    ticket.setId(id1);
                    ticket.setStart_station(start_station);
                    ticket.setStop_station(stop_station);
                    ticket.setStart_time(start_time);
                    ticket.setTicket_price(ticket_price);
                    System.out.println(ticket.toString());
                }
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }

        return ticket;
    }

    @Override
    public List<Ticket> queryAll()
    {   //这个不是自己出的
        List<Ticket> list = new ArrayList<>();
        //添加，list.add();
        //取，list.get();

        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "select id,start_station,stop_station,start_time,ticket_price from ticket";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                System.out.println("语句编写完成");
                //设置参数


                //4.执行
                ResultSet resultSet = preparedStatement.executeQuery();
                //解析结果集
                while (resultSet.next())
                {   //取 id
                    int id1 = resultSet.getInt("id");
                    //取开始车站
                    String start_station = resultSet.getString("start_station");
                    //取到达车站
                    String stop_station = resultSet.getString("stop_station");
                    //发车时间
                    String start_time = resultSet.getString("start_time");
                    //票价
                    int ticket_price = resultSet.getInt("ticket_price");
                    //封装到对象里边去
                    Ticket ticket = new Ticket();
                    ticket.setId(id1);
                    ticket.setStart_station(start_station);
                    ticket.setStop_station(stop_station);
                    ticket.setStart_time(start_time);
                    ticket.setTicket_price(ticket_price);
                    System.out.println(ticket.toString());
                    //新加的，将一个车票对象，装入集合对象
                    list.add(ticket);

                }
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }
        return list;
    }

    @Override
    public List<Ticket> querytiaojian(query query)
    {   //这个不是自己出的
        List<Ticket> list = new ArrayList<>();
        //添加，list.add();
        //取，list.get();

        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "select id,start_station,stop_station,start_time,ticket_price from ticket Where 1=1 ";
                //3.1建一个袋子，下边设置参数1，2，3，4， 的时候用得到
                List<Object> param = new ArrayList<>();
                System.out.println("语句编写加强,特别好");
                if (query.getId()!=null)
                {
                    sql=sql+" and id=?";
                    param.add(query.getId());
                }
                if (query.getStart_station()!=null )
                {
                    sql=sql+" and start_station=?";
                    param.add(query.getStart_station());
                }
                if (query.getStop_station()!=null )
                {
                    sql=sql+" and stop_station=?";
                    param.add(query.getStop_station());
                }
                if (query.getStart_time()!=null )
                {
                    sql=sql+" and start_time=?";
                    param.add(query.getStart_time());
                }
                if (query.getTicket_pricea()!=null )
                {
                    sql=sql+" and ticket_price > ?";
                    param.add(query.getTicket_pricea());
                }
                if (query.getTicket_priceb()!=null )
                {
                    sql=sql+" and ticket_price<?";
                    param.add(query.getTicket_priceb());
                }
                    //这里是分页，加上limit
                    sql=sql+" LIMIT ?,? ";
                param.add(query.getKaishixiabiao());//分页开始数字
                param.add(query.getPageSize());//分页字段

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                //设置参数
               // preparedStatement.setInt(1,query.getId());
                //for循环设置参数
                System.out.println("sql="+sql);
                for( int a=0;a<param.size();a++)
                {
                    preparedStatement.setObject(a+1,param.get(a));
                }

                //4.执行
                ResultSet resultSet = preparedStatement.executeQuery();
                //解析结果集
                while (resultSet.next())
                {   //取 id
                    int id1 = resultSet.getInt("id");
                    //取开始车站
                    String start_station = resultSet.getString("start_station");
                    //取到达车站
                    String stop_station = resultSet.getString("stop_station");
                    //发车时间
                    String start_time = resultSet.getString("start_time");
                    //票价
                    int ticket_price = resultSet.getInt("ticket_price");
                    //封装到对象里边去
                    Ticket ticket = new Ticket();
                    ticket.setId(id1);
                    ticket.setStart_station(start_station);
                    ticket.setStop_station(stop_station);
                    ticket.setStart_time(start_time);
                    ticket.setTicket_price(ticket_price);
                    System.out.println(ticket.toString());
                    //新加的，将一个车票对象，装入集合对象
                    list.add(ticket);

                }
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }
        return list;
    }

    @Override
    public fenyetiaojian yongtiaojianchafenye(query query)
    {
        fenyetiaojian fenyetiaojian = new fenyetiaojian();
        TicketDao ticketDao = new TicketDao();
        List<Ticket> querytiaojian = ticketDao.querytiaojian(query);
        //总数据
        fenyetiaojian.setData(querytiaojian);
        //当前页
        Integer currentPage = query.getCurrentPage();
        fenyetiaojian.setCurrentPage(currentPage);
        //每页显示条数
        Integer pageSize = query.getPageSize();
        fenyetiaojian.setPageSize(pageSize);
        //共多少条,要查数据库，下边是查询数据库条数的方法
        TicketDao ticketDao1 = new TicketDao();
        Integer totalNum = ticketDao1.chaxuntiaoshu(query);
        fenyetiaojian.setTotalNum(totalNum);
        //共多少页,等于（总条数+每页显示条数-1）除以.每页显示条数
        Integer totalPage = (totalNum+pageSize-1)/pageSize;
        fenyetiaojian.setTotalPage(totalPage);


        return fenyetiaojian;
    }
    @Override
    public Integer chaxuntiaoshu(query query)
    {   //这个不是自己出的
        Integer x1=0;
        //添加，list.add();
        //取，list.get();

        //1.加载
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_data", "root", "root");
                //3.创建编译语句
                String sql= "select count(1) x from ticket Where 1=1 ";
                //3.1建一个袋子，下边设置参数1，2，3，4， 的时候用得到
                List<Object> param = new ArrayList<>();
                System.out.println("语句编写加强,特别好");
                if (query.getId()!=null)
                {
                    sql=sql+" and id=?";
                    param.add(query.getId());
                }
                if (query.getStart_station()!=null )
                {
                    sql=sql+" and start_station=?";
                    param.add(query.getStart_station());
                }
                if (query.getStop_station()!=null )
                {
                    sql=sql+" and stop_station=?";
                    param.add(query.getStop_station());
                }
                if (query.getStart_time()!=null )
                {
                    sql=sql+" and start_time=?";
                    param.add(query.getStart_time());
                }
                if (query.getTicket_pricea()!=null )
                {
                    sql=sql+" and ticket_price > ?";
                    param.add(query.getTicket_pricea());
                }
                if (query.getTicket_priceb()!=null )
                {
                    sql=sql+" and ticket_price<?";
                    param.add(query.getTicket_priceb());
                }
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                //设置参数
                // preparedStatement.setInt(1,query.getId());
                //for循环设置参数
                System.out.println("sql="+sql);
                for( int a=0;a<param.size();a++)
                {
                    preparedStatement.setObject(a+1,param.get(a));
                }

                //4.执行
                ResultSet resultSet = preparedStatement.executeQuery();
                //解析结果集
                while (resultSet.next())
                {
                    x1 = resultSet.getInt("x");
                }
                //5.关闭
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL写的有问题");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("价包调用有问题");
        }
        return x1;
    }
    @Test
    public void ces()
    {
        query query = new query();
        TicketDao ticketDao = new TicketDao();
        Integer chaxuntiaoshu = ticketDao.chaxuntiaoshu(query);
        System.out.println("chaxuntiaoshu="+chaxuntiaoshu);
    }

}