package com.example.service.impl;

import com.example.entity.Person;
import com.example.resource.Database;
import com.example.service.PersonService;

import java.util.List;

public class PersonServiceImpl  implements PersonService {
    @Override
    public Person getnum(int num){
        List<Person> ps = Database.getPersons();//调用静态代码 把静态代码块调用 返回静态的列表集合
        Person p1 = null;
        for (Person p:ps) {
            if(num == p.getNum())
            {
                p1 = p;
                break;
            }
        }
        return p1;
    };
}
