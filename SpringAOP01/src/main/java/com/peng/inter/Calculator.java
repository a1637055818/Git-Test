package com.peng.inter;

import org.springframework.stereotype.Component;

/**
 * 接口不加载到容器中
 * 实际上也可以加，加了也不创建对象，
 * 只要这个组件是一个接口
 * 相当于告诉Spring,ioc容器中有这种类型的组件
 * @author 16370
 * @create 2021-03-28 下午 3:07
 */
public interface Calculator {

    public int add(int i,int j);
    public int sub(int i,int j);
    public int mul(int i,int j);
    public int div(int i,int j);
}
