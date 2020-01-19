package com.example.service;

public interface TeacherService extends PersonService {

    /*
     *  声明抽象方法，计算指定职称教师的全部出版物数量
     *  @return sum
     */
    int sumpubilsh(String postiton);
}
