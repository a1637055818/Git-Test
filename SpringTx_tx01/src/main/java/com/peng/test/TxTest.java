package com.peng.test;

import com.peng.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 16370
 * @create 2021-03-29 上午 11:12
 */
public class TxTest {

    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象
     */
    @Test
    public void test(){
        BookService bean = ioc.getBean(BookService.class);

        bean.checkout("zhifei", "isbn-001");

        System.out.println(bean.getClass());
    }
}
