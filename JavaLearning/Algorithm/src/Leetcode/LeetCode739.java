package Leetcode;

import java.util.*;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/11 8:51
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class LeetCode739 {
    //从后往前遍历
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    //单调栈的思想
    public int[] dailyTemperatures2(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekLast()]) {
                int pre = stack.pollLast();
                result[pre] = i - pre;
            }
            stack.addLast(i);

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        leetCode739.dailyTemperatures(new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78});
    }
}
