package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            double b = Math.random() * 100;
            Integer bi = (int) b;
            //System.out.println(bi);
            a.add(bi);
        }
        Test.searchEven(a);
        sout(Test.searchOdd(a));
        sout(Test.searchOdd1(a));

    }

    static void sout(List<Integer> a) {
        int i = 0;
        int p = 0;
        while (i < a.size()) {
            System.out.print(p++);
            System.out.println(" " + a.get(i++));
        }

    }

    static List<Integer> searchEven(List<Integer> a) {
        return a.stream().filter(k -> k % 2 == 0).collect(Collectors.toList());
    }

    static List<Integer> searchOdd(List<Integer> a) {
        return a.stream()
                .filter(k -> (k % 2 == 0 && k < 30))
                .collect(Collectors.toList());
    }

    static List<Integer> searchOdd1(List<Integer> a) {
        return a.stream()
                .filter(k -> k % 2 == 0)
                .filter(k -> k < 30)
                .collect(Collectors.toList());
    }
}
