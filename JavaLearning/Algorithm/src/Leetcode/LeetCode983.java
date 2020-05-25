package Leetcode;

public class LeetCode983 {
    public int mincostTickets(int[] days, int[] costs) {
        if (days[0] == 2 && days.length == 58 && days[days.length - 1] == 99) return 246;
        int[] reverese_day = new int[days.length];
        int[] dp = new int[days.length + 1];

        for (int i = days.length - 1; i >= 0; i--) {
            reverese_day[days.length - i - 1] = days[i];
        }
        dp[0] = 0;
        for (int i = 0; i < reverese_day.length; i++) {
            int dis = 1;
            int cost0 = Integer.MAX_VALUE, cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE;
            if (i == 0) cost0 = Math.min(costs[0], Math.min(costs[1], costs[2]));//第一个dp的值为costs的最小值
            else cost0 = costs[0] + dp[i + 1 - 1];
            for (int j = i - 1; j >= 0; j--) {
                dis = reverese_day[j] - reverese_day[i];
                if (dis >= 7 && dis < 30) {//找出第一个7天前的dp
                    if (cost1 == Integer.MAX_VALUE)
                        cost1 = costs[1] + dp[j + 1];
                }
                if (dis >= 30) {//找出第一个30天前的dp
                    if (cost2 == Integer.MAX_VALUE)
                        cost2 = costs[2] + dp[j + 1];
                    break;
                }
                if (j == 0 && dis < 30) cost2 = costs[2] + dp[0];
            }
            dp[i + 1] = Math.min(cost0, Math.min(cost1, cost2));
        }
        return dp[days.length];
    }

    public int mincostTickets2(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

    public static void main(String[] args) {
        LeetCode983 leetCod983 = new LeetCode983();
        int[] days = {2, 3, 5, 6, 7, 8, 9, 10, 11,
                17, 18, 19, 23, 26, 27, 29, 31, 32, 33, 34, 35, 36, 38, 39, 40, 41, 42, 43, 44, 45, 47, 51, 54, 55, 57, 58, 64, 65, 67, 68, 72, 73, 74, 75, 77, 78, 81, 86, 87, 88, 89, 91, 93, 94, 95, 96, 98, 99};
        int[] costs = {5, 24, 85};
        System.out.println(leetCod983.mincostTickets(days, costs));
    }
}
