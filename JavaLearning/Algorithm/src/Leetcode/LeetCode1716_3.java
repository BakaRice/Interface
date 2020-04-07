package Leetcode;

/*

一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
在每次预约服务之间要有休息时间，因此她不能接受相邻的预约
。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 */
public class LeetCode1716_3 {
    public int massage(int[] nums) {
        int max = 0;
        int tmax = 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length > 2) {
            int tan[] = new int[nums.length];
            tan[0] = nums[0];
            tan[1] = nums[1];
            tmax = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                if (max < tan[i - 2]) {
                    max = tan[i - 2];
                }
                tan[i] = nums[i] + max;
                if (tmax < tan[i]) tmax = tan[i];
            }
        }
        return tmax;
    }

    public int massage2(int[] nums) {
        int dp[] = new int[nums.length];
        if (nums.length == 0) return 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 2] + nums[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        LeetCode1716_3 leetCode1716_3 = new LeetCode1716_3();
        int s[] = {1, 3, 1};
        leetCode1716_3.massage(s);
    }
}
