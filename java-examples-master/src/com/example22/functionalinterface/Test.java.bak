package com.example22.functionalinterface;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("BO");
        s1.setLearnable(() -> System.out.println("我要按自己的方式阅读"));
        System.out.println(s1.getLearnable());
        s1.getLearnable().read();

        Student s2 = new Student("SUN");
        Learnable learnable = () -> {
            int number = 10;
            System.out.println("我要读" + number + "本书");
        };

        s2.setLearnable(learnable);
        System.out.println(s2.getLearnable());
        s2.getLearnable().read();
    }
}
