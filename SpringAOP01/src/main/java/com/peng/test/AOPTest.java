package com.peng.test;

import com.peng.impl.MyMathCalculator;
import com.peng.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 16370
 * @create 2021-03-28 下午 2:46
 */
public class AOPTest {

    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 正常执行：@Before(前置通知)-->@After(后置通知)-->@AfterReturning(正常返回通知);
     * 异常执行：@Before(前置通知)-->@After(后置通知)-->@AfterThrowing(方法异常)
     *
     * 环绕只是影响当前切面
     *  多个切面顺序：
     *
     */
    @Test
    public void test2(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        bean.div(1, 1);
    }

    @Test
    public void test1(){

        //1.从ioc容器中拿到目标对象,
        // 注意：如果想要用类型，一定要用他的接口类型
        //不要用他本类
        //细节1：class com.sun.proxy.$Proxy13
        //Aop底层就是动态代理，容器中保存的组件是他的代理对象，
        //不是他的本类的类型
        //代理对象和目标对象唯一产生关联的是都有同一个接口
        //IOC找的是代理对象
//        Calculator bean = ioc.getBean(Calculator.class);
//        bean.add(1, 3);
//        System.out.println(bean);
//        System.out.println(bean.getClass().getName());

        //没有接口就是本类类型
        //class com.peng.impl.MyMathCalculator$$EnhancerByCGLIB$$8548da79
        //cglib帮我们创建好的代理对象
        //有接口就转成接口类型，没接口就转成本类类型
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        bean.add(1, 2);
        System.out.println(bean);
        System.out.println(bean.getClass());

    }


}
