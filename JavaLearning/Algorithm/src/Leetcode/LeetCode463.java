package Leetcode;

public class LeetCode463 {
    int[][] g_grid;

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        g_grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += search(i, j);
            }
        }
        return sum;
    }

    private int search(int i, int j) {
        if (g_grid[i][j] == 0) return 0;
        else if (g_grid[i][j] == 1) {
            int r = 4;
            if (i - 1 >= 0 && g_grid[i - 1][j] == 1) {
                r--;
            }
            if (i + 1 < g_grid[0].length && g_grid[i + 1][j] == 1) {
                r--;
            }
            if (j - 1 >= 0 && g_grid[i][j - 1] == 1) {
                r--;
            }
            if (j + 1 < g_grid.length && g_grid[i][j + 1] == 1) {
                r--;
            }
            return r;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode463 leetCode463 = new LeetCode463();
        int[][] g = new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int[][] g1 = new int[][]{{1,0}};
        System.out.println(leetCode463.islandPerimeter(g1));
    }
}
