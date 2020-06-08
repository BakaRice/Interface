package Leetcode.Exercise.array;

/**
 * @author RiceFamily
 * @date 2020/6/4 14:57
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 */

/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class T10 {
    public boolean isValidSudoku(char[][] board) {
        if (chunk(board, 1, 1) && chunk(board, 1, 4) && chunk(board, 1, 7) &&
                chunk(board, 4, 1) && chunk(board, 4, 4) && chunk(board, 4, 7) &&
                chunk(board, 7, 1) && chunk(board, 7, 4) && chunk(board, 7, 7)
        ) {
            for (int i = 0; i < 9; i++) {
                if (!col(board, 1)) return false;
            }
            for (int i = 0; i < 9; i++) {
                if (!row(board, 1)) return false;
            }
            return true;
        }
        return false;
    }

    private boolean row(char[][] board, int i) {
        System.out.println("===row" + i + 1 + "====");
        int[] nums = new int[10];
        for (int j = 0; j < 9; j++) {
            int cur = board[i][j] - '0';
            if (board[i][j] != '.') {
                System.out.println(cur);
                if (nums[cur] == 0)
                    nums[cur]++;
                else return false;
            }
        }
        return true;
    }

    private boolean col(char[][] board, int i) {
        System.out.println("===col" + i + 1 + "====");
        int[] nums = new int[10];
        for (int j = 0; j < 9; j++) {
            int cur = board[j][i] - '0';
            if (board[j][i] != '.') {
                System.out.println(cur);
                if (nums[cur] == 0)
                    nums[cur]++;
                else return false;
            }
        }
        return true;

    }

    private boolean chunk(char[][] board, int x, int y) {
        int[] nums = new int[10];
        int[] dx = {0, 0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {0, 1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i <= 8; i++) {
            int cur = board[x + dx[i]][y + dy[i]] - '0';
            if (board[x + dx[i]][y + dy[i]] != '.') {
                System.out.println(cur);
                if (nums[cur] == 0)
                    nums[cur]++;
                else return false;
            }
        }
        return true;
    }
}

//[
//        [".",".","4",".",".",".","6","3","."],
//        [".",".",".",".",".",".",".",".","."],
//        ["5",".",".",".",".",".",".","9","."],
//        [".",".",".","5","6",".",".",".","."],
//        ["4",".","3",".",".",".",".",".","1"],
//        [".",".",".","7",".",".",".",".","."],
//        [".",".",".","5",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".","."]
//]