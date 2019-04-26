package com.example.service.impl;


import com.example.entity.Student;
import com.example.resource.Database;
import com.example.service.StudentService;


import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{

    @Override
    public List<Student> addStudent(Student student){
        Database.getStudents().add(student);//getStudents return了database的内容 然后调用其中的add方法
        return Database.getStudents();
    }

    @Override
    public List<Student> listStudentsByYear(int year){
        return Database.getStudents()
                .stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toList());//将流内的内容转换为一个新的list
    }
    @Override
    public List<String> listStudentsNames(int years,Student.Sex sex){
        return Database.getStudents()
                .stream()
                .filter(student -> student.getSex() == sex)
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }
    @Override
    public Map<Student.Sex,List<Student>>mapStudentsBySex(){
        return Database.getStudents()
                .stream()
                .collect(Collectors.groupingBy(Student->Student.getSex()));//不懂groupingby是什么意思
    }
    @Override
    public boolean removeStudent(int id){
        return Database.getStudents()
                .removeIf(student -> student.getId()==id);
    }
}