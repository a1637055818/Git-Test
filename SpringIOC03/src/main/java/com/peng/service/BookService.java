package com.peng.service;

import com.peng.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16370
 * @create 2021-03-27 下午 10:04
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void save(){
        System.out.println("save方法....");
        bookDao.saveBook();
    }
}
