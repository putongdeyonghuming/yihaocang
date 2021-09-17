package com.day04.ssmspring.test;
/*讲的是spring创建对象1*/
import com.day04.ssmspring.model.Ticket;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestTicket
{
    /*使用new()创建对象*/
    @Test
    public void test1()
    {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        System.out.println(ticket.toString());
    }
    /*使用spring创建对象*/
    /*把Ticket交给spring管理
    * 从spring里获取对象
    * 第一种*/
    @Test
    public void test2()
    {
       //1.加载spring文件
       Resource classPathResource = new ClassPathResource("spring-config.xml");
       //2创建容器
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
       //3从容器中获取对象,就是new个对象（这是第一种，，根据在spring里定的值取）
        Ticket t = (Ticket) xmlBeanFactory.getBean("t");
        t.setId(1);
        System.out.println(t.toString());
    }
    @Test
    public void test3()
    {
        //1.加载spring文件
        Resource classPathResource = new ClassPathResource("spring-config.xml");
        //2创建容器
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        //3从容器中获取对象,就是new个对象（这是第二种，根据类名.class取）
        Ticket t = (Ticket) xmlBeanFactory.getBean(Ticket.class);

        System.out.println(t.toString());
    }
    @Test
    public void test4()
    {
        //1.加载spring文件
        Resource classPathResource = new ClassPathResource("spring-config.xml");
        //2创建容器
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        //3从容器中获取对象,就是new个对象（这是第二三种，根据类名.class和spring里的值取取）
        Ticket t = (Ticket) xmlBeanFactory.getBean("t",Ticket.class);

        System.out.println(t.toString());
    }
    /*下边的文件讲了，如何用spring创建测试文件*/
}
