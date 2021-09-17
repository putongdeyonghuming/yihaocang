package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//这里是Mybatis的工具类，可以把DAO层里来回调用的方法放在这里边
//工具类都是静态方法，可以直接在其他方法里，用这个类名点方法，不用创建对象直接访问，下边的java是更好的这个工具类的写法
public class MybatisUtil
{

    //获取一个getsqlSessionFactory1
    public static SqlSessionFactory getsqlSessionFactory1()
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
}

