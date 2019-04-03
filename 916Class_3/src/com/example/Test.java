package com.example;

import com.example.service.PersonService;
import com.example.service.impl.PersonServiceImpl;
import com.example.service.impl.StudentServiceImpl;
import com.example.service.impl.TeacherServiceImpl;

public class Test {
    public static void main(String[] args) {
        doPersonServiceImpl();
        doStudentServiceImpl();
        doTeacherServiceImpl();

    }

     static void doPersonServiceImpl(){
        PersonServiceImpl p1 = new PersonServiceImpl();
         System.out.println(p1.getnum(2).getName());
     }

    static void  doStudentServiceImpl(){
         StudentServiceImpl p1 = new StudentServiceImpl();
         System.out.println(p1.averagecount(2));
     }

    static void  doTeacherServiceImpl(){
         TeacherServiceImpl p1 = new TeacherServiceImpl();
         System.out.println(p1.sumpubilsh("教授"));

     }
}
