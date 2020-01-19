package com.example;

import com.example.entity.Student;
import com.example.resource.Database;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StudentServiceImpl stuService = new StudentServiceImpl();//调用实用类

        List<Student> tempstudenlist = stuService.listStudents();//读入学生信息
        for (Student u:tempstudenlist) {//遍历输出
            System.out.println("学生姓名："+u.getName()+" 学号："+u.getId());
        }

       Scanner reader = new Scanner(System.in);
        System.out.println("输入学生学号以及姓名");
        int tid = reader.nextInt();
        String tname = reader.nextLine();
        Student stutemp = new Student(tid, tname);//读入学生信息
        stuService.addStudent(stutemp);//将学生信息加入数据库；
        System.out.println("fix end");
        //tempstudenlist = stuService.listStudents();//读入学生信息
        for (Student u:tempstudenlist) {
            System.out.println("学生姓名："+u.getName()+" 学号："+u.getId());
        }
// 2017000000 nul
        System.out.print("输入查询学号：");

        System.out.println(stuService.getStudent(reader.nextInt()).getName());
        System.out.print("输入查询年级：");
        List<Student> gradelist = stuService.listStudentsByYear(reader.nextInt());//按照年级查询并且制表
        for (Student u:gradelist) {//遍历输出
            System.out.println("学生姓名："+u.getName()+" 学号："+u.getId());
        }
    }
}
