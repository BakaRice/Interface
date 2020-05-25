package Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeInterview13 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int movingCount(int m, int n, int k) {
        int sum = 0;
        if (m == 0 || n == 0) return 0;
        int map[][] = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        map[0][0] = 1;
        if (0 <= k) sum++;//对源点进行判断
        while (!queue.isEmpty()) {
            int[] remove = queue.remove();

            for (int i = 0; i < 4; i++) {
                int curx = remove[0] + dx[i];
                int cury = remove[1] + dy[i];
                if (curx < 0 || curx >= m || cury < 0 || cury >= n || (curx / 10 + curx % 10 + cury / 10 + cury % 10) > k || map[curx][cury] == 1)
                    continue;
                else {
                        queue.add(new int[]{curx, cury});
                        map[curx][cury] = 1;
                        sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCodeInterview13 leetCodeInterview13 = new LeetCodeInterview13();
        System.out.println(leetCodeInterview13.movingCount(11, 8, 16));
    }
}
