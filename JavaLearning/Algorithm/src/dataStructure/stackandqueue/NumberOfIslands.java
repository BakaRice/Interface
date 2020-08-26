package dataStructure.stackandqueue;

import Leetcode.LeetCode200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RiceFamily
 * @date 2020/7/21 15:29
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 */
public class NumberOfIslands {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        boolean jud[][] = new boolean[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Queue<int[]> queue = new LinkedList<>();
                if (!jud[i][j] && grid[i][j] == '1') {
                    sum++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int currx = curr[0] + dx[d];
                            int curry = curr[1] + dy[d];
                            if (currx >= 0 && currx < grid.length && curry >= 0 && curry < grid[0].length &&
                                    !jud[currx][curry] && grid[currx][curry] == '1') {
                                queue.add(new int[]{currx, curry});
                                jud[currx][curry] = true;
                            }
                        }
                    }
                }
                queue.clear();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfIslands l = new NumberOfIslands();
        char[][] t = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(l.numIslands(t));
    }
}
