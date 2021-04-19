package com.peng.service;

import com.peng.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 16370
 * @create 2021-03-29 上午 11:08
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 结账：传入那个用户买了书
     *
     * 事务细节
     * isolation-Isolation:事务的隔离级别
     *
     *
     * propagation-Propagation:事务的传播行为
     *  传播行为(事务的传播+事务的行为)
     *      如果有多个事务进行嵌套运行,子事务是否要和大事务共用一个事务
     *
     *
     *
     * noRollbackFor-class[]:那些异常事务可以不回滚
     *  noRollbackForClassName-String[](String全类名):
     *
     * rollbackFor-class[]:哪些异常事务需要回滚
     *  rollbackForClassName-String[]:
     *
     *  异常分类：
     *      运行时异常(非检查异常)：可以不用处理，默认都回滚
     *      编译时异常：要么try-catch，要么在方法上声明throws，
     *              默认不回滚
     *  事务的回滚：默认是发生运行时异常都回滚，而发生编译时异常不会回滚
     *  noRollbackFor:那些异常事务可以不回滚(可以让原来回滚的异常给他不回滚)
     *  noRollbackFor = {ArithmeticException.class}
     *
     *  rollbackFor:原本不回滚(编译时异常)的异常让他回滚
     *
     *
     * readOnly-boolean:设置事务为只读事务
     *  可以进行事务优化
     *  readOnly=true；加快查询速度，不用管事务那些操作
     *
     * timeout-int(秒为单位):超时，事务超出指定执行时长后自动终止并回滚
     *
     * @param username
     * @param isbn
     */
    @Transactional(timeout =3)
    public void checkout(String username,String isbn){
        //1.减库存
        bookDao.updateStock(isbn);

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int price = bookDao.getPrice(isbn);
        //2.减余额
        bookDao.updateBalance(username, price);

        //int i=10/0;
    }

}
