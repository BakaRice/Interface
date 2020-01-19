package com.example.resource;

import com.example.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class Database {
   private static List<Student> tpstus = create();//tpstus -> tempstudents（临时学生数组表）
    private static List<Student> create(){

        List <Student> tempstus = new ArrayList<Student>();
        Student  stu1 = new Student(2017214317, "TAN");
        Student  stu2 = new Student(2016224475, "YANG");
        Student  stu3 = new Student(2017214307, "CHEN");
        tempstus.add(stu1);//我需要写一个静态方法，才能把对象对应的方法调用
        tempstus.add(stu2);
        tempstus.add(stu3);
        return tempstus;
    }
    public static List<Student> getTpstus() {
        return tpstus;
    }

    public void addTpstus(Student stu) {
        tpstus.add(stu);
    }

}
