package com.example.entity;

public class Student {

    /*需求+1
    在com.example.entity下，创建学生实体类，包含学号，姓名，成绩，班级编号；
    创建4个参数的构造函数用于初始化。允许使用快捷键alt+insert，生成getter/setter方法，以及构造函数
    */

    private int number;
    private String name;
    private  int results;
    private int classNo;

    public Student(int number,String name,int results,int classNo){
        this.number = number;
        this.classNo = classNo;
        this.results = results;
        this.name = name;
    }

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public void printInfo(){
        System.out.println( "姓名："+this.name
                            +"，学号："+this.number
                            +",成绩："+this.results
                            +"，班级编号："+this.classNo);
    }
}
