package com.example.service;

import com.example.entity.Person;

public interface PersonService {
/*
 * 声明抽象方法，基于用户编号，返回用户
 * @return Person
 */
    Person getnum(int num);


}
