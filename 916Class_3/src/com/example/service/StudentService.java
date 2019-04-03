package com.example.service;

public interface StudentService extends  PersonService{
    /*
     *声明抽象方法，计算指定班级的学生平均分
     * @return ave
     */
    float averagecount(int clasnum);
}
