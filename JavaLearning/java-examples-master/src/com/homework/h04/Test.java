package com.homework.h04;

import com.homework.h04.entity.Student;
import com.homework.h04.service.StudentService;
import com.homework.h04.service.impl.StudentServiceImpl;

public class Test {
    private static StudentService service = new StudentServiceImpl();
    public static void main(String[] args) {
        addStudentTest();
        System.out.println("--------------");
        getStudentTest();
        System.out.println("--------------");
        listStudentsByYearTest();
    }

    private static void addStudentTest() {
        service.addStudent(new Student(2017_8989, "BO"));
        service.listStudents()
                .forEach(s -> System.out.println(s.getName()));
    }

    private static void getStudentTest() {
        System.out.println(service.getStudent(2017_1124).getName());
    }

    private static void listStudentsByYearTest() {
        service.listStudentsByYear(2017)
                .forEach(s -> System.out.println(s.getName()));
    }
}
