package com.test;

import com.peng.service.BookService;
import com.peng.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * 使用Spring的单元测试
 * 1.导包，Spring的单元测试包
 * 2.使用@ContextConfiguration来指定Spring的配置文件的位置
 * 3.@RunWith指定用哪种驱动进行单元测试，默认就是Junit
 *  @RunWith(SpringJUnit4ClassRunner.class)
 *  使用Spring的单元测试模块来执行表了@Test的测试方法
 *  以前@Test注解只是由Junit执行
 * @author 16370
 * @create 2021-03-27 下午 10:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestIOC {

   // ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

    ApplicationContext ioc=null;

    @Autowired
    BookService bookService;

    @Test
    public void test3(){
        System.out.println(bookService);
    }


    @Test
    public void test2() throws SQLException {
        BookServlet bean = ioc.getBean(BookServlet.class);
        bean.doGet();
    }


    /**
     * 使用注解加入到容器中的组件，和使用配置加入到容器的组件行为都是默认的
     * 1.组件的id默认就是组件的类型首字母小写
     * 2.组件的作用域，默认就是单例的
     *
     */
    @Test
    public void test1(){
        Object bean = ioc.getBean("bookDao");
        Object bean2 = ioc.getBean("bookDao");
        System.out.println(bean==bean2);
    }
}
