package com.mmall.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author arbonkeep
 * @date 2020/8/7 - 16:24
 */
public class BigDecimalTest {
    @Test
    public void test1() {
        System.out.println(0.05 + 0.01);
        System.out.println(1.0-0.31);

    }


    @Test
    public void test2() {
        BigDecimal bigDecimal = new BigDecimal(0.05);
        BigDecimal bigDecima2 = new BigDecimal(0.01);

        System.out.println(bigDecimal.add(bigDecima2));

    }

    @Test
    public void test3() {
        BigDecimal bigDecimal = new BigDecimal("0.05");
        BigDecimal bigDecima2 = new BigDecimal("0.01");
        System.out.println(bigDecimal.add(bigDecima2));

//        在使用BigDecimal时需要使用String构造器传入数据保持精度，否则精度不准确

    }

}
