package com.peng.Test;

import org.junit.jupiter.api.Test;

/**
 * @author 16370
 * @create 2021-04-18 下午 9:48
 */
public class Test01 {

    @Test
    public void test01(){
        Integer i1=new Integer(11);
        Integer i2=new Integer(11);
        System.out.println(i1 == i2);//f

        Integer i3=126;
        Integer i4=126;
        int i5=126;
        System.out.println(i3 == i4); //t
        System.out.println(i3 == i5);//t
        Integer i6=128;
        Integer i7=128;
        int i8=128;
        System.out.println(i6 == i7);//f
        System.out.println(i6 == i8);//f
    }
}
