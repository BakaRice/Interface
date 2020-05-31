package Leetcode;

import java.util.Stack;

/**
 * @author RiceFamily
 * @date 2020/5/25 22:16
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<>();
        if (s.length() % 2 == 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') sk.push(cur);
            else if (cur == ')' || cur == ']' || cur == '}') {
                if (sk.isEmpty()) return false;
                char peak = sk.peek();
                if ((peak == '(' && cur == ')') || (peak == '[' && cur == ']') || (peak == '{' && cur == '}')) sk.pop();
                else sk.push(cur);
            }
        }
        if (sk.isEmpty()) return true;
        else return false;
    }
}
