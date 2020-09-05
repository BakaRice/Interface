package Leetcode;

public class LeetCode486 {
    //抄
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    //零和博弈的思想，所以对于玩家2的计分方式，他的分数是负值计算，玩家1则作为参考系为正指（或0）计算
    private int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        //递归 当前选择开头的数 加上当前选择后的total后果计算
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        //递归 当前选择结尾的数 加上当前选择后的total后果计算
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        //统计分数事，乘以turn能将分数转化为正值，进行大小判断
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

    //抄 dp
    public boolean PredictTheWinner_2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;

    }
}
