package com.homework.h04.service.impl;

import com.homework.h04.entity.Student;
import com.homework.h04.resource.Database;
import com.homework.h04.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> listStudents() {
        return Database.getStudents();
    }

    @Override
    public void addStudent(Student stu) {
        Database.getStudents().add(stu);
    }

    @Override
    public Student getStudent(int sid) {
        for (Student s : Database.getStudents()) {
            if (sid == s.getId()) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        List<Student> students = new ArrayList<>();
        for (Student s : Database.getStudents()) {
            if ((s.getId() / 10000) == year) {
                students.add(s);
            }
        }
        return students;
    }
}
