package com.example10.staticvariable;

public class StaticTest {
    private static int num = 10;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("--------set/get static variable --------");
        getStaticVariable();
        System.out.println(num);
        num++;
    }
    static {
        System.out.println("StaticVariable static block");
    }
    private static void getStaticVariable() {
        Bicycle b = new Bicycle();
        Bicycle b2 = new Bicycle();
        Bicycle b3 = new Bicycle();
        System.out.println("Current Bicycle amount: "
                + Bicycle.getAmount());
        System.out.println(Bicycle.COMPANY);
    }

    private static void getStudent() {
        Student s1 = new Student("BO", Student.MALE);
        Student s2 = new Student("SUN", Student.FEMALE);

    }

}
