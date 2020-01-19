package com.example;

public class Student {
    private String name;//学生姓名
    private Sex sex;//学生性别

    public Student(String name,Sex sex){
        this.name = name;
        this.sex = sex;
    }
    public Student(){

    }

    public void setSex(Sex sex) {
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




    public enum Sex{
        MALE,FAMALE
    }//学生性别


}
