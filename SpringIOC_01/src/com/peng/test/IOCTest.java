package com.peng.test;

import com.peng.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 16370
 * @create 2021-03-26 下午 7:06
 */
public class IOCTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    ApplicationContext ioc = new ClassPathXmlApplicationContext("bean2.xml");
    ApplicationContext ioc2 = new ClassPathXmlApplicationContext("bean3.xml");


    @Test
    public void  test8(){
       Object bean = ioc2.getBean("myFactoryBean");
        System.out.println(bean);
    }

    @Test
    public void  test7(){
        Object bean = ioc2.getBean("factory02");
        System.out.println(bean);
    }

    @Test
    public void  test6(){
        Object bean = ioc2.getBean("factory01");
        System.out.println(bean);
    }

    /**
     * 按照配置的顺序创建bean
     * 内部bean是不能用id获取的
     * 级联属性可以修改属性的属性，注意：原来的bean的值可能会被修改
     */
    @Test
    public void test5(){
        Person p = ioc.getBean("person02",Person.class);
     //   Car car1 = p.getCar();
        //Car car2 = ioc.getBean(Car.class);
        System.out.println(p);
      //  System.out.println(car1==car2);
    }


    @Test
    public void test4(){
        Person p1 = context.getBean("person04", Person.class);
        System.out.println(p1);
    }

    /**
     *
     */
    @Test
    public void test3(){
        Person p1 = context.getBean("person03", Person.class);
        System.out.println(p1);
    }

    /**
     *
     * .NoUniqueBeanDefinitionException:
     * No qualifying bean of type [com.peng.bean.Person]
     * is defined: expected single matching bean but found 2:
     * person01,com.peng.bean.Person#0
     * 通过bean的类型从ioc容器中获取bean的实例
     *
     * 如果ioc容器中这个类型的bean有多个，查找就会报错
     */
    @Test
    public void test2(){
        //Person p1 = (Person) context.getBean("person02");
        Person p1 = context.getBean("person02", Person.class);
        System.out.println(p1);
    }



    /**
     *
     * 从容器拿到这个组件
     * 1.容器中对象的创建：在容器创建完成的时候就已经创建了
     * 2.同一个组件在ioc容器中是单实例的，容器启动完成都已经创建好的
     * 3.容器中如果没有这个组件，获取组件？
     * no bean named 'xxxx' is defined
     * 报异常
     * 4.IOC容器在创建这个组件对象的时候，会利用setter方法为javabean属性赋值
     * 5.javabean的属性名是由什么决定的？
     * getter/setter方法是属性名，set去掉,后面那一串首字母小写就是属性名
     * 所有getter/setter方法都自动生成
     */
    @Test
    public void test1(){
        //ApplicationContext：代表IOC容器
        //ClassPathXmlApplicationContext：当前应用的xml配置文件在classpath下
        //根据spring的配置文件得到ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        Person p1 = context.getBean(Person.class);
        Person p1 = (Person) context.getBean("person01");
        Person p2 = (Person) context.getBean("person01");
//        System.out.println(p1==p2);
        System.out.println("=================");

    }
}

