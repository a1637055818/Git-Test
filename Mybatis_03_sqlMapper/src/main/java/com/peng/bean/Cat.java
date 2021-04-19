package com.peng.bean;

/**
 * @author 16370
 * @create 2021-04-11 下午 2:34
 */
public class Cat {

    private Integer id;
    private String cName;
    private Integer age;
    private Integer gender;

    public Cat() {
    }

    public Cat(Integer id, String cName, Integer age, Integer gender) {
        this.id = id;
        this.cName = cName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", cName='" + cName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
