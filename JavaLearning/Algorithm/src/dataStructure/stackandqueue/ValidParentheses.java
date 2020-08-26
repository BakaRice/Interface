package dataStructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author RiceFamily
 * @date 2020/7/22 13:06
 */
public class ValidParentheses {
    public boolean isValid(String s) {
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
}
