package com.day03.ssmkuangjia.dao.impl;

import com.day03.ssmkuangjia.dao.ITicketDao;
import com.day03.ssmkuangjia.model.Ticket;
import com.util.MybatisUtil1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.security.PublicKey;
import java.util.List;
//使用mybatis完成CRUD

public class TickectDao implements ITicketDao
{
    @Override
    public void save(Ticket ticket)
    {
        try
        {
            //下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
            sqlSession.insert("org.mybatis.example.BlogMapper.tt",ticket);//每个方法对应的sqlSession的方法都不一样
            //比查找多的开启事务,将信息推动给mysql
            sqlSession.commit();
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("执行报错了新增");
        }

    }

    @Override
    public void delectById(Integer id)
    {
        try
        {
            //下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
            sqlSession.delete("org.mybatis.example.BlogMapper.shanchu",id);//每个方法对应的sqlSession的方法都不一样
            //比查找多的开启事务,将信息推动给mysql
            sqlSession.commit();
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("执行报错了删除");
        }

    }

    @Override
    public void update(Ticket ticket)
    {try
    {
        //下边的这个是mybatis的主配置文件地址
        String resource = "myBatis-config.xml";
        //下边的是读配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
        sqlSession.update("org.mybatis.example.BlogMapper.gengxin",ticket);//每个方法对应的sqlSession的方法都不一样
        //比查找多的开启事务,将信息推动给mysql
        sqlSession.commit();
        sqlSession.close();

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("执行报错了新增");
    }
    }

    @Override
    public Ticket queryById(Integer id)
    {
        Ticket ticket1 = null;
        try
        {
            //下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
            ticket1 = (Ticket)sqlSession.selectOne("org.mybatis.example.BlogMapper.yy", id);
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("执行报错了单个查询");
        }

        return ticket1;
    }

    @Override
    public List<Ticket> queryAll()
    {
        List<Ticket> list=null;
        try
        {
            //下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
             //selectList可以查询，不需要参数，在上边声明了
             list = sqlSession.selectList("org.mybatis.example.BlogMapper.quancha");
            sqlSession.close();
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("执行报错了单个查询");
        }

        return list;
    }
    /*优化这个DAO,
        sqlSessionFactory这个对象多次创建是很耗费时间的，需要让他在系统里只执行一次不关闭，
        优化这个的方法就是在下边建了一个取这个值的方法，一般是放在util工具包里的*/


    public SqlSessionFactory getsqlSessionFactory1()
    {SqlSessionFactory sqlSessionFactory = null;
        try {
            //下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    //使用上图优化之后的写一个方法
    @Override
    public Ticket queryById1(Integer id)
    {
        Ticket ticket1 = null;
        try
        {
            /*//下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
*/
            //这种方法可以不用new直接执行就好
            SqlSessionFactory sqlSessionFactory =getsqlSessionFactory1();
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
            ticket1 = (Ticket)sqlSession.selectOne("org.mybatis.example.BlogMapper.yy", id);
            sqlSession.close();
            //把下边异常里的IO去掉，上边的异常里都是有IO的，
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("执行报错了单个查询");
        }
        return ticket1;
    }

    @Override
    public Ticket queryById2(Integer id) {
        Ticket ticket1 = null;
        try
        {
            /*//下边的这个是mybatis的主配置文件地址
            String resource = "myBatis-config.xml";
            //下边的是读配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
*/
            //这种方法可以不用new直接执行就好
            //SqlSessionFactory sqlSessionFactory =getsqlSessionFactory1();
            //SqlSession sqlSession = sqlSessionFactory.openSession();
            //这是教程里最优化的方法了
            SqlSession sqlSession = MybatisUtil1.getsqlSession();
            //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
            ticket1 = (Ticket)sqlSession.selectOne("org.mybatis.example.BlogMapper.yy", id);
            sqlSession.close();
            //把下边异常里的IO去掉，上边的异常里都是有IO的，
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("执行报错了单个查询");
        }
        return ticket1;
    }

    @Override
    public void save1(Ticket ticket) {
        SqlSessionFactory sqlSessionFactory = MybatisUtil1.getsqlSessionFactory1();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //这里可以对，sqlSession，完成增删改查,下边的值去mapper里的xml里取，和上边方法传过来的值
        sqlSession.insert("org.mybatis.example.BlogMapper.tt",ticket);//每个方法对应的sqlSession的方法都不一样
        //比查找多的提交事务,将信息推动给mysql
        sqlSession.commit();
        sqlSession.close();
    }
}
