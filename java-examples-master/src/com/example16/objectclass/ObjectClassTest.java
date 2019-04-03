package com.example16.objectclass;

import java.lang.reflect.Method;

public class ObjectClassTest {
    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {
        System.out.println("-------Object getClass--------");
        getClazz();
        System.out.println("-------Object toString--------");
        getToString();
        System.out.println("-------Abstract class--------");
        getAbstractClass();
    }
    private static void getClazz() {
        User u = new User("BO");
        System.out.println(u.getClass().getName());
        System.out.println(u.getClass().getSimpleName());
    }



    // 了解即可
    private static void getClazz2() throws ClassNotFoundException {
        // 动态获取类型信息
        Class<?> bClass =
                Class.forName("com.example16.objectclass.User");
        System.out.println(bClass.getName());
        System.out.println(bClass.getSuperclass());
        for (Class<?> c : bClass.getInterfaces()) {
            System.out.println(c.getName());
        }
        for (Method m : bClass.getDeclaredMethods()) {
            System.out.println(m.getName());
        }
    }

    private static void getToString() {
        User u = new User("BO");
        System.out.println(u);
        System.out.println(u.toString());
    }

    private static void getAbstractClass() {
        Person person = new Person("BO");
        person.sleep();
        person.move();
        Animal animal = new Animal("Lion");
        animal.sleep();
        animal.move();
    }
}
