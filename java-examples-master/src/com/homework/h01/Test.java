package com.homework.h01;

/**
 * 作业1
 * 需求：设计学生实体类，必须包含姓名与性别属性(即，构造时就必须有初始化值)，
 * 属性包含手动编写的getter/setter，有参构造函数；性别通过创建静态内部枚举类型实现；
 *
 * 编写主函数，创建测试对象
 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("BO", Student.Sex.MALE);
        Student s2 = new Student("SUN", Student.Sex.FEMALE);
        System.out.println(s2.getSex());
        System.out.println(s2.getName());
    }
}
