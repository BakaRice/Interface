package com.example;

import com.example.entity.Student;
import com.example.resource.Database;
import com.example.service.impl.StudentServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Database stu = new Database();
        Student s1 = new Student(201007, Student.Sex.MALE, "haha", 2017);
        StudentServiceImpl stu_ser_imp = new StudentServiceImpl();
        System.out.println("输出原数据库内容");printStu(Database.getStudents());//输出原数据库内容
        System.out.println("输出add后内容");printStu(stu_ser_imp.addStudent(s1));//输出add后内容
        System.out.println("输出2011年龄内容");printStu(stu_ser_imp.listStudentsByYear(2011));//输出2011年龄内容
        stu_ser_imp.listStudentsNames(2011, Student.Sex.MALE);//输出返回指定届，指定性别的全部学生的姓名
        System.out.println("输出是否成功删除");System.out.println(stu_ser_imp.removeStudent(201007));//输出是否成功删除
        printStu(Database.getStudents());
    }

    public static void printStu(List<Student> temp) {
        //student的list
       for (Student p : temp) {
            System.out.println(p.getName());
        }
        System.out.println("*******");
    }
}