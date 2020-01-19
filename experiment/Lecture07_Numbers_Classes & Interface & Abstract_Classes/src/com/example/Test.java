package com.example;

public class Test {
    /*
     * 基本类型数据的计算效率，远高于基于对象计算的效率(需要先拆箱，再计算，再装箱)
     *  因此，不要在装箱拆箱状态下计算
     */
    public static void main(String[] args) {
        long s1 = System.nanoTime();
        Integer i1 = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            i1 = i1+1;
        }
        long e1 = System.nanoTime();
        System.out.println(e1-s1);
        //基本类型测试
        long s2 = System.nanoTime();
        int i2 = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            i2 = i2+1;
        }
        long e2 = System.nanoTime();
        System.out.println(e2-s2);
    }
}
