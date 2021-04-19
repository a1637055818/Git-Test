package com.peng.bean;

/**
 * @author 16370
 * @create 2021-03-26 下午 9:58
 */
public class Person {
    private String lastName;
    private Integer age;

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

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
