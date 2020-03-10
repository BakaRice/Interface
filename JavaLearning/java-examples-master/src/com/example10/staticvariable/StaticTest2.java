package com.example10.staticvariable;

public class StaticTest2 {
    private static final Bicycle bicycle = getBicycle();
    public static void main(String[] args) {
        System.out.println(bicycle);
        System.out.println(bicycle);
    }
    private static Bicycle getBicycle() {
        return new Bicycle();
    }
}
