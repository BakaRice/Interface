package Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
 */
public class LeetCode200 {
    int dx[] = {0, 0, -1, 1};
    int dy[] = {1, -1, 0, 0};


    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int sum_land = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { //如果是陆地且为1 则表示首次探索到
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        grid[x][y] = '2';
                        for (int d = 0; d < 4; d++) {
                            int tx = x + dx[d];
                            int ty = y + dy[d];
                            if (tx >= grid[0].length || tx < 0 || ty >= grid.length || ty < 0) {
                                continue;
                            }
                            if (grid[tx][ty] != '1')
                                continue;
                            else {
                                grid[tx][ty] = '2';
                                queue.add(new int[]{tx, ty});
                            }
                        }
                    }
                    sum_land++;
                } else if (grid[i][j] == '0' || grid[i][j] == '2') {
                    //为海洋或者曾今探索过则直接跳过
                    continue;
                }
                queue.clear();
            }
        }
        return sum_land;
    }

    public static void main(String[] args) {
        LeetCode200 l = new LeetCode200();
        char[][] t = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(l.numIslands(t));
    }
}
