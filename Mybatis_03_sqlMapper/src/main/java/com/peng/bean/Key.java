package com.peng.bean;

/**
 * @author 16370
 * @create 2021-04-11 下午 7:19
 */
public class Key {

    private Integer id;//钥匙id
    private String keyName;//钥匙名

    private Lock lock;

    public Key() {
    }

    public Key(Integer id, String keyName) {
        this.id = id;
        this.keyName = keyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", lock=" + lock +
                '}';
    }
}
