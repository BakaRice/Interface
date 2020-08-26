package Leetcode.Exercise.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author RiceFamily
 * @date 2020/6/26 19:03
 */
public class T5 {
    public boolean isValid(String s) {
        Deque<Character> sk = new ArrayDeque<Character>();
        char[] xs = s.toCharArray();
        for (int i = 0; i < xs.length; i++) {
            if ((xs[i] == ')' || xs[i] == ']' || xs[i] == '}')) {
                if (!sk.isEmpty()) {
                    int x = xs[i] - sk.peekLast();
                    if (x == 1 || x == 2) sk.pollLast();
                    else return false;
                } else return false;
            }
            if (xs[i] == '(' || xs[i] == '[' || xs[i] == '{') sk.addLast(xs[i]);
        }
        if (sk.isEmpty()) return true;
        else return false;
    }

    public boolean isValid_2(String s) {
        Deque<Character> sk = new ArrayDeque<Character>();
        char[] xs = s.toCharArray();
        for (int i = 0; i < xs.length; i++) {
            if (!sk.isEmpty() && (xs[i] - sk.peekLast() == 1 || xs[i] - sk.peekLast() == 2)) {
                sk.pollLast();
            } else sk.addLast(xs[i]);
        }
        if (sk.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        T5 t5 = new T5();
        System.out.println(t5.isValid("{[]}"));
    }
}
