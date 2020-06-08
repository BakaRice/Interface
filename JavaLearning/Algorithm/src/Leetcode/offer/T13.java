package Leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RiceFamily
 * @date 2020/6/2 15:34
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class T13 {
    boolean[][] jud;

    public int movingCount(int m, int n, int k) {
        int ans = 0;
        jud = new boolean[m][n];
        if (m == 0 || n == 0 || k == 0) return ans;
//        else return bfs(m, n, k);
        else return dfs(0, 0, m, n, k);
    }

    private int dfs(int i, int j, int m, int n, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || cal(i, j) > k || jud[i][j])
            return 0;
        jud[i][j] = true;
        return dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k) + 1;
    }

    private int bfs(int m, int n, int k) {
        int sum = 0;
        Queue<int[]> deque = new LinkedList();
        deque.add(new int[]{0, 0});
        sum++;
        while (!deque.isEmpty()) {
            int[] ints = deque.poll();
            if (ints[0] + 1 <= m - 1 && cal(ints[0] + 1, ints[1]) <= k && !jud[ints[0] + 1][ints[1]]) {
                deque.add(new int[]{ints[0] + 1, ints[1]});
                jud[ints[0] + 1][ints[1]] = true;
                sum++;
            }
            if (ints[1] + 1 <= n - 1 && cal(ints[0], ints[1] + 1) <= k && !jud[ints[0]][ints[1] + 1]) {
                deque.add(new int[]{ints[0], ints[1] + 1});
                jud[ints[0]][ints[1] + 1] = true;
                sum++;
            }
        }
        return sum;
    }

    private int cal(int i, int j) {
        int curr = 0;
        while (i > 0) {
            curr += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            curr += j % 10;
            j = j / 10;
        }
        return curr;
    }


    public static void main(String[] args) {
        T13 t13 = new T13();
        System.out.println(t13.movingCount(3, 2, 17));
    }

}
