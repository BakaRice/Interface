package Leetcode;

public class LeetCode1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int sum = 0;

        int[] remainder = new int[60];
        for (int t : time) {
            remainder[t % 60]++;
        }
        for (int i = 1; i < 30; i++) {
            sum += remainder[i] * remainder[60 - i];
        }
        sum += (remainder[0] * (remainder[0] - 1) + remainder[30] * (remainder[30] - 1)) / 2;
        return sum;
    }

    //更好的一次遍历的方法
    public int numPairsDivisibleBy60_2(int[] time) {
        int second[] = new int[60];
        int ans = 0;
        for (int t : time) {
            int mod = t % 60;
            int remain = mod == 0 ? 0 : 60 - mod;
            ans += second[remain];
            second[mod]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1010 leetCode1010 = new LeetCode1010();
        int nums[] = {30, 20, 150, 100, 40};
        System.out.println(leetCode1010.numPairsDivisibleBy60_2(nums));
    }
}
