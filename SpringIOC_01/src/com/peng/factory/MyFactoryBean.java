package com.peng.factory;

import com.peng.bean.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * Spring会自动调用工厂方法创建实例
 *
 * 1.编写一个FactoryBean的实现类
 * 2.在Spring配置文件中进行注册
 * @author 16370
 * @create 2021-03-26 下午 9:40
 */
public class MyFactoryBean  implements FactoryBean<Person> {
    /**
     * getObject：工厂方法
     * 返回创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Person getObject() throws Exception {
        System.out.println("MyFactoryBean创建对象.....");
        Person person = new Person();
        person.setLastName("知非");
        return person;
    }

    /**
     * 返回创建的对象的类型
     * Spring会自动调用这个方法来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * isSingleton：是单例？
     * false：不是
     * true：是
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
