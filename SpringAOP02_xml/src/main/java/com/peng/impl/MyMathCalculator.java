package com.peng.impl;

import com.peng.inter.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author 16370
 * @create 2021-03-28 下午 3:07
 */
//@Service
public class MyMathCalculator /*implements Calculator*/ {


    public int add(int i, int j) {
        System.out.println("内部执行...");
        int res=i+j;
        return res;
    }

    public int sub(int i, int j) {
        System.out.println("内部执行...");
        int res=i-j;
        return res;
    }

    public int mul(int i, int j) {
        System.out.println("内部执行...");
        int res=i*j;
        return res;
    }

    public int div(int i, int j) {
        System.out.println("内部执行...");
        int res=i/j;
        return res;
    }
}
