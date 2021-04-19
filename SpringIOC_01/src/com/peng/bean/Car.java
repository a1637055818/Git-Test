package com.peng.bean;

/**
 * @author 16370
 * @create 2021-03-26 下午 7:59
 */
public class Car {

    private String carName;
    private Integer price;
    private String color;

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
