package com.peng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author 16370
 * @create 2021-03-26 下午 9:59
 */
public class TestBean {

   ApplicationContext ioc= new ClassPathXmlApplicationContext("bean.xml");
   ApplicationContext ioc2= new ClassPathXmlApplicationContext("applicationContext.xml");

   @Test
   public void test2() throws Exception {
      //1.从容器中拿到连接池
      //DataSource dataSource = (DataSource) ioc.getBean("dataSource");
      //2.按照类型获取组件，可以获取到这个类型下的所有实现类子类
      DataSource dataSource = ioc2.getBean("dataSource", DataSource.class);

      System.out.println(dataSource.getConnection());
   }

   /**
    * 单例：bean的生命周期：
    * 构造器-->初始化方法--->(容器关闭)销毁方法
    * 多实例：
    *    获取bean（构造器-->初始化方法）
    *    -->容器关闭不会调用bean的销毁方法
    */
   @Test
    public void test1(){
       Object bean = ioc.getBean("person01");
       System.out.println(bean);
   }
}
