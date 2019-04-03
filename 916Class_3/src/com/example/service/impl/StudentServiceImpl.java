package com.example.service.impl;

import com.example.entity.Person;
import com.example.entity.Student;
import com.example.resource.Database;
import com.example.service.StudentService;

import java.util.List;

public  class StudentServiceImpl extends PersonServiceImpl implements StudentService {

    @Override
    public float averagecount(int clasnum) {
        List<Person> ps = Database.getPersons();//调用静态代码 把静态代码块调用 返回静态的列表集合
        float total=0;
        int number=0;
        for (Person p:ps) {
            if(p instanceof Student){
                if(((Student)p).getClasnum()==clasnum) {
                    total = total + ((Student) p).getGarde();
                    number++;
                }
            }
        }
        return number==0?0:total/number;
    }
}
