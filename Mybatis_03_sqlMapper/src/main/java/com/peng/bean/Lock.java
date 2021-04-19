package com.peng.bean;

import java.util.List;

/**
 * @author 16370
 * @create 2021-04-11 下午 7:19
 */
public class Lock {

    private Integer id;
    private String lockName;

    //查询锁子的时候，把所有的钥匙查出来
    private List<Key> keys;
    //1-n：外键一定放在n的一端
    //n-n：中间表存储对应关系

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", keys=" + keys +
                '}';
    }
}
