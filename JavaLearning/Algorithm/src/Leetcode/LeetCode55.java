package Leetcode;

public class LeetCode55 {
    public boolean canJump1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    int minTime;
    int times;
    public boolean canJump2(int[] nums) {
        boolean canReach = false;
        minTime=Integer.MAX_VALUE;
        times = 0;
        boolean backtrack = canjump2_backtrack(nums, 0);
        return backtrack;
    }

    boolean canjump2_backtrack(int[] nums, int index) {
        if (index >= nums.length - 1) {
            if (times<minTime) minTime = times;
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        int all = nums[index];
        for (int i = 0; i <nums[index]; i++) {
            times++;
            boolean backtrack = canjump2_backtrack(nums, index + i + 1);
            times--;
            //改了一下这里 便于统计次数
//            if (backtrack == true) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(nums[i] + i, max);
            }
            if (max >= len - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode55 l = new LeetCode55();
        int[] nums = new int[]{1,2,3};
        System.out.println(l.canJump2(nums));
    }
}
