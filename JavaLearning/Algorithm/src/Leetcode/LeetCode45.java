package Leetcode;


public class LeetCode45 {
    int minTime;
    int times;

    //回溯法 超时
    public int jump2(int[] nums) {
        boolean canReach = false;
        minTime = Integer.MAX_VALUE;
        times = 0;
        boolean backtrack = canjump2_backtrack(nums, 0);
        return minTime;
    }

    //回溯法 超时
    boolean canjump2_backtrack(int[] nums, int index) {
        if (index >= nums.length - 1) {
            if (times < minTime) minTime = times;
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        int all = nums[index];
        for (int i = 0; i < nums[index]; i++) {
            times++;
            boolean backtrack = canjump2_backtrack(nums, index + i + 1);
            times--;
//            if (backtrack == true) return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    //梅开二度练习
    public int jump3(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        LeetCode45 l = new LeetCode45();
        //4, 2, 0, 0, 1, 1
        System.out.println(l.jump3(new int[]{2, 3, 1, 1, 4}));
    }

}
