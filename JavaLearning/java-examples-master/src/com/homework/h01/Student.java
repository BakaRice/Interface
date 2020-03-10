package com.homework.h01;

public class Student {
    private String name;
    private Sex sex;
    public static enum Sex {
        MALE,FEMALE
    }
    public Student(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


}
