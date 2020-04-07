package Leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class LeetCode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int spilt[] = new int[len];
        int flag = 0;
        Stack<Integer> s1 = new Stack<Integer>();// put (
        Stack<Integer> s2 = new Stack<Integer>();//put )
        for (int i = 0; i < len; i++) {
            if (seq.charAt(i) == '(') s1.push(i);
            else if (seq.charAt(i) == ')') s2.push(i);
            if (!s1.isEmpty() && !s2.isEmpty()) {
               flag = i%2;
                spilt[s1.pop()] = flag;
                spilt[s2.pop()] = flag;
            }
        }
        return spilt;
    }
    public int[] maxDepthAfterSplit2(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1111 l = new LeetCode1111();
        l.maxDepthAfterSplit2("(()())");
    }
}
