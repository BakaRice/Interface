package com.example.service.impl;

import com.example.entity.Person;
import com.example.entity.Teacher;
import com.example.resource.Database;
import com.example.service.TeacherService;

import java.util.List;

public  class TeacherServiceImpl extends PersonServiceImpl implements TeacherService {
    @Override
    public int sumpubilsh(String postiton) {
        List<Person> ps =  Database.getPersons();
        int total =0;
        for (Person p:ps) {
            if(p instanceof Teacher){
                if(((Teacher)p).getPosition().equals(postiton)) {
                    total = total + ((Teacher) p).getPublishnum();
                }
            }

        }
        return total;
    }
}
