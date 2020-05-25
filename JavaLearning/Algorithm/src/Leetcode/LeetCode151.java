package Leetcode;

import java.util.ArrayList;

public class LeetCode151 {
    public String reverseWords(String s) {
        String reverseWord = new String();
        s = s.trim();
        if (s.length() == 0) return reverseWord;
        int end = s.length() - 1;
        int start = end;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ' || i == 0) {
                end = i;
                String substring = s.substring(end);
                if (i == 0) substring = ' ' + substring;
                if (!substring.equals(" "))
                    reverseWord = reverseWord + substring;
                s = s.substring(0, end);
            }
        }
        return reverseWord.substring(1);
    }

    public static void main(String[] args) {
        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords("a good   example"));
    }
}
