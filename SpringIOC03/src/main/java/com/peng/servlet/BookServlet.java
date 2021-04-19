package com.peng.servlet;

import com.peng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 方法上有@Autowired的话：
 * 1.这个方法也会在bean创建的时候自动运行
 * 2.这个方法上的每一个参数都会自动注入值
 *
 * 属性的自动注入
 * @Autowired
 * Spring会自动的为这个属性赋值
 * @author 16370
 * @create 2021-03-27 下午 10:04
 */
@Controller
public class BookServlet {

    //@Qualifier：指定一个名作为id，让Spring别使用变量名作为id
    @Qualifier("bookService")
    @Autowired
    private BookService bookService;

    @Autowired
    private DataSource dataSource;

    public void doGet() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        System.out.println("doget方法.....");
        bookService.save();
    }

}
