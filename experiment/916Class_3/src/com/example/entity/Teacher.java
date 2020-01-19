package com.example.entity;

import javax.naming.Name;

public class Teacher extends Person{
    private String position;//职称
    private int publishnum;//出版数量
    Teacher(){
      super();
    };
    public Teacher(int num,String name,String position,int publishnum){
        super(num, name);
        this.position = position;
        this.publishnum = publishnum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPublishnum() {
        return publishnum;
    }

    public void setPublishnum(int publishnum) {
        this.publishnum = publishnum;
    }
}
