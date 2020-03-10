package com.example;

public class China implements Computable {//china类实现computable接口
    int number;
    public  int f(int x){//记得写上关键字public  因为在接口中写出的就是public abstract 类型的变量
        //在底下写的时候必须也要用public 不然就会出现降低访问的问题 这是不被允许的
        int sum = 0;
        for(int i =1;i<=x;i++)
             sum =sum +i;
        return sum;
    }
}
