package com.example.entity;

public class Student extends Person{
    private int clasnum;//班级
    private float  garde;//成绩

    public  Student(){

    }

    public Student(int num,String name,int clasnum,float garde){
        super(num,name);
        this.clasnum = clasnum;
        this.garde = garde;
    }
    public int getClasnum() {
        return clasnum;
    }

    public void setClasnum(int clasnum) {
        this.clasnum = clasnum;
    }

    public float getGarde() {
        return garde;
    }

    public void setGarde(float garde) {
        this.garde =garde;
    }
}
