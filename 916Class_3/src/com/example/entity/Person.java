package com.example.entity;

public class Person {
    private int num;//编号
    private String name;//姓名

    public Person(int num, String name) {
        this.num = num;
        this.name = name;

    }
     public Person(){

    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
