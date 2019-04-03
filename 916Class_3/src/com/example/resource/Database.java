package com.example.resource;
import com.example.entity.Person;
import com.example.entity.Student;
import com.example.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Person> persons = create();//静态直接用
    public static List<Person> create(){
     List<Person> p= new ArrayList<>();
        p.add(new Student(1,"aTan",01,80));
        p.add(new Student(2,"aYang",02,46));
        p.add(new Student(3,"aBing",02,60));
        p.add(new Student(4,"aYao",03,99));
        p.add(new Teacher(5, "Daliu", "教授", 20));
        p.add(new Teacher(5, "DaQi", "副教授", 5));
        p.add(new Teacher(5, "DaDou", "讲师", 0));

        return   p;
    }

    public static List<Person> getPersons() {
        return persons;
    }

}
