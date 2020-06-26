package Leetcode.Exercise.math;

import java.util.HashMap;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 21:28
 */
public class T4 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hp = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        char[] xs = s.toCharArray();
        int sum = 0;
        int pre = hp.get(xs[0]);
        for (int i = 1; i < xs.length; i++) {
            int num = hp.get(xs[i]);
            if (pre < num)
                sum -= pre;
            else
                sum += pre;
            pre = num;
        }
        sum += pre;
        return sum;
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        System.out.println(t4.romanToInt("IV"));
    }
}
