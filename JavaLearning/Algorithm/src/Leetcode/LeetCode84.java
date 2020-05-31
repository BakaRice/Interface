package Leetcode;

import java.util.Stack;

/**
 * @author RiceFamily
 * @date 2020/5/30 16:16
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int hmin = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (hmin > heights[j]) hmin = heights[j];
                int tmp = hmin * (j - i + 1);
                if (tmp > max) max = tmp;
            }
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode84 leetCode84 = new LeetCode84();
        leetCode84.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3});
    }
}
