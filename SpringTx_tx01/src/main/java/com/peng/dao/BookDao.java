package com.peng.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 16370
 * @create 2021-03-29 上午 10:32
 */
@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 1.减余额
     * <p>
     * 减去某个用户的余额
     */
    public void updateBalance(String userName, int price) {
        String sql =
                "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql, price, userName);
    }

    /**
     * 2.获取某本书的价格
     *
     * @return
     */
    public int getPrice(String isbn) {
        String sql = "select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    /**
     * 3.减库存:减去某本书的库存，为了简单，每次减一
     */
    public void updateStock(String isbn){
        String sql="update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql,isbn );
    }
}
