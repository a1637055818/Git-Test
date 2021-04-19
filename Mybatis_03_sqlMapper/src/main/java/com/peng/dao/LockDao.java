package com.peng.dao;

import com.peng.bean.Lock;

/**
 * @author 16370
 * @create 2021-04-11 下午 8:13
 */
public interface LockDao {


    //查锁子的时候将所有钥匙也查出来
    //private List<Key> keys;
    public Lock getLockById(Integer id);

    public Lock getLockByIdSimple(Integer id);

  //  public Lock getLockByIdByStep(Integer id);

}
