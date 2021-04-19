package com.peng.dao;

import com.peng.bean.Key;

/**
 * @author 16370
 * @create 2021-04-11 下午 7:27
 */
public interface KeyDao {

    /**
     * 将钥匙和锁子信息一起查出
     * @param id
     * @return
     */
    public Key getKeyById(Integer id);

    public Key getKeyByIdSimple(Integer id);
}
