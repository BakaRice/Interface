package com.example11.nestedclass;

public class NestedClassTest {
    public static void main(String[] args) {
        getStaticNestedClass();
    }

    /**
     * 封装人的属性，包括基于静态内部类创建的属性
     */
    private static void getStaticNestedClass() {
        Person.IQ iq = new Person.IQ(250);
        Person person = new Person("BO",iq);
        System.out.println(person.getIq().getScore());
    }
}
