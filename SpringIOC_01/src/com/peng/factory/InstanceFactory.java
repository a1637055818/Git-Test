package com.peng.factory;

import com.peng.bean.Person;

/**
 * 实例工厂
 * @author 16370
 * @create 2021-03-26 下午 9:15
 */
public class InstanceFactory {

    public  Person getPerson(String lastName){
        System.out.println("InstanceFactory.....");
        Person person = new Person();
        person.setLastName(lastName);
        return person;
    };

}
