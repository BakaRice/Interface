package Leetcode;

/*
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
请你返回最终形体的表面积。
 */
public class LeetCode0892 {
    public int surfaceArea(int[][] grid) {
        if (grid.length == 0) return 0;
        int sum = 0;
        int sum1 = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = grid[i][0];
            for (int j = 0; j < grid[0].length; j++) {
                if (max < grid[i][j])
                    max = grid[i][j];
                sum1++;
            }
            sum = sum + max;
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (max < grid[i][j])
                    max = grid[i][j];
            }
            sum = sum + max;
            sum1++;
        }
        return sum * 2 + sum1;
    }

    public int surfaceArea2(int[][] grid) {
        if (grid.length == 0) return 0;
        int sum = 0;
        int verCover = 0;
        int colCover = 0;
        int rowCover = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                if (grid[i][j] > 1) verCover += (grid[i][j] - 1) * 2;
                if (i > 0) colCover += Math.min(grid[i - 1][j], grid[i][j]);
                if (j > 0) colCover += Math.min(grid[i][j - 1], grid[i][j]);
            }
        }
        return sum * 6 - (colCover + verCover + rowCover) * 2;

    }

    public int surfaceArea3(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0)
                    //假设每个v=grid[i][j]都是独立的。
                    result += grid[i][j] * 4 + 2;
                //减去面贴在一起的情况
                if (i > 0)
                    result -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                if (j > 0)
                    result -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0892 leetCode0892 = new LeetCode0892();
        int gird[][] = {{1, 2}, {3, 4}};
        int gird1[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(leetCode0892.surfaceArea(gird1));
    }
}
