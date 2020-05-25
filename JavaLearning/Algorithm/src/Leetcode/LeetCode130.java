package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode-cn.com/problems/surrounded-regions/
X X X X
X O O X
X X O X
X O X X

X X X X
X X X X
X X X X
X O X X
 */
public class LeetCode130 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 0 || n == 0) return;
        boolean[][] jud = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (jud[i][j] == false) {
                    jud[i][j] = true;
                    if (board[i][j] == 'O')
                        bfs(board, i, j, jud);
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j, boolean[][] jud) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new LinkedList<>();
        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});
        boolean touchBoundary = false;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            //如果在边界位置 且 为‘O’ touchBoundary 置为 true
            if (poll[0] == 0 || poll[0] == board.length - 1 || poll[1] == 0 || poll[1] == board[0].length - 1)
                touchBoundary = true;
            for (int k = 0; k < 4; k++) {
                int cx = poll[0] + dx[k], cy = poll[1] + dy[k];
                if (cx < 0 || cx >= board.length || cy < 0 || cy >= board[0].length || jud[cx][cy])
                    continue;
                else {
                    //如果没有越界 先将jud数组置为true 表示遍历过此处
                    jud[cx][cy] = true;
                    if (board[cx][cy] == 'O') {
                        //如果在边界位置 且 为‘O’ touchBoundary 置为 true
                        if (cx == 0 || cx == board.length - 1 || cy == 0 || cy == board[0].length - 1)
                            touchBoundary = true;
                        list.add(new int[]{cx, cy});
                        queue.add(new int[]{cx, cy});
                    }
                }
            }
        }
        if (!touchBoundary) {
            for (int[] curr : list) {
                board[curr[0]][curr[1]] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] b = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        leetCode130.solve(b);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
