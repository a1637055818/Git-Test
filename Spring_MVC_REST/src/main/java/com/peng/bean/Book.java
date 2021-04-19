package com.peng.bean;

/**
 * @author 16370
 * @create 2021-03-30 下午 10:57
 */
public class Book {

    /**
     * 书名：<input name="bookName" type="text"><br>
     *     作者：<input name="author" type="text"><br>
     *     价格：<input name="price" type="text"><br>
     *     库存：<input name="stock" type="text"><br>
     *     销量：<input name="sales" type="text"><br>
     */
    private String bookName;
    private String author;
    private double price;
    private Integer stock;
    private Integer sales;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Book() {
    }

    public Book(String bookName, String author, double price, Integer stock, Integer sales) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", address=" + address +
                '}';
    }
}
