package com.peng.factory;

import com.peng.bean.Person;

/**
 * 静态工厂
 * @author 16370
 * @create 2021-03-26 下午 9:15
 */
public class StaticFactory {

    public static Person getPerson(String lastName){
        System.out.println("StaticFactory.....");
        Person person = new Person();
        person.setLastName(lastName);
        return person;
    };
}
