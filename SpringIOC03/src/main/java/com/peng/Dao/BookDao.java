package com.peng.Dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * id默认就是类名首字母小写
 * @author 16370
 * @create 2021-03-27 下午 10:04
 */
//@Scope(value = "singleton")
@Repository("bookDao")
public class BookDao {

    public void saveBook(){
        System.out.println("保存一本书");
    }
}
