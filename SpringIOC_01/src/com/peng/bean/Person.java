package com.peng.bean;

import java.util.List;
import java.util.Map;

/**
 * @author 16370
 * @create 2021-03-26 下午 6:59
 */
public class Person {
    //基本属性类型直接使用
    //<property name="lastName" value="张三"></property>
    //自动进行类型装换
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    private Car car;
    private List<Book> books;

    private Map<String,Object> maps;

    public Person() {
    }

    public Person(String lastName, Integer age, String gender, String email) {
        System.out.println("有参构造器被调用.....");
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
}
