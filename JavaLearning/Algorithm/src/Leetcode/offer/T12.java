package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/6/2 15:03
 */
public class T12 {
    char[] c;

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean[][] jud = new boolean[board.length][board[0].length];
        c = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c[0]) {
                    if (dfs(board, jud, i, j, 1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] jud, int i, int j, int index) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || jud[i][j] || board[i][j] != c[index]) {
            return false;
        }
        if (index == c.length) return true;
        jud[i][j] = true;
        boolean res = dfs(board, jud, i + 1, j, index + 1)
                || dfs(board, jud, i - 1, j, index + 1)
                || dfs(board, jud, i, j + 1, index + 1)
                || dfs(board, jud, i, j - 1, index + 1);
        jud[i][j] = false;
        return res;
    }


}
