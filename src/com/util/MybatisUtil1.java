package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
//这方法里无论创建多少对象只执行一次，因为是静态代码块，没懂、
//之后大家取sqlSessionFactory，的值，只需要下图这么写就行了
//SqlSessionFactory sqlSessionFactory = MybatisUtil1.getsqlSessionFactory1();
public class MybatisUtil1
{private static SqlSessionFactory sqlSessionFactory = null;
static
{
    try {
        //下边的这个是mybatis的主配置文件地址
        String resource = "myBatis-config.xml";
        //下边的是读配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    //获取一个getsqlSessionFactory1
    public static SqlSessionFactory getsqlSessionFactory1()
    {
        return sqlSessionFactory;
    }
    //进一步简化，直接取到dao里的SqlSession sqlSession = sqlSessionFactory.openSession();
    //因为sqlSession，只能每个方法使用单独的，所以这么写了
    public static SqlSession getsqlSession()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
