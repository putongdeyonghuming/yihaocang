package com.day04.ssmspring.test;
/*讲的是spring创建对象2*/
import com.day04.ssmspring.model.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*这是新的用spring的测试方法，就是少了创建对象的那步，改用spring创建对象，现在更少写几行*/
@RunWith(SpringJUnit4ClassRunner.class)//把junit加载到spring容器里边去
@ContextConfiguration("classpath:spring-config.xml")//读取spring的配置方法，这个是主配置文件
public class TestTicket1 {
@Autowired //前边那个东西的作用和下边是必须一起写的，作用是自动注入对象，从spring里取beanFactory对象
    BeanFactory beanFactory;
    @Test
    public void test()
    {
        //现在创建对象，用上边的beanFactory.getbean就可以了，相比之前的少写了一点，用t
        //用t去spring-config里取实际的值，在new出来
        Ticket t = (Ticket) beanFactory.getBean("t",Ticket.class);
        System.out.println(t.toString());
    }
}
