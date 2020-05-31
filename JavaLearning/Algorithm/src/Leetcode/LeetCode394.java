package Leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author RiceFamily
 * @date 2020/5/28 8:34
 * https://leetcode-cn.com/problems/decode-string/
 */
public class LeetCode394 {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime-- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public String decodeString_self(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stk_multi = new LinkedList<>();
        LinkedList<String> stk_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stk_multi.addLast(multi);
                stk_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stk_multi.removeLast();
                while (cur_multi-- > 0) {
                    tmp.append(res);
                }
                res = new StringBuilder(stk_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi*10+ Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 =new LeetCode394();
        System.out.println(leetCode394.decodeString_self("100[leetcode]"));
    }
}
