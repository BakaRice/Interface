package com.homework.h04.resource;


import com.homework.h04.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Student> students = create();
    private static List<Student> create() {
        students = new ArrayList<>();
        Student s1 = new Student(2016_1566, "高小松");
        Student s2 = new Student(2016_7744, "徐硕");
        Student s3 = new Student(2017_1124, "刘新春");
        Student s4 = new Student(2017_7421, "王怡");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        return students;
    }

    public static List<Student> getStudents() {
        return students;
    }
}
