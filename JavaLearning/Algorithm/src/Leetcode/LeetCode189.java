package Leetcode;

//189. 旋转数组
//https://leetcode-cn.com/problems/rotate-array/

import java.util.Arrays;

public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] ro = new int[]{1, 2, 3, 4, 5, 6, 7};
        leetCode189.rotate(ro, 3);
        Arrays.stream(ro).forEach(System.out::print);

    }
}
