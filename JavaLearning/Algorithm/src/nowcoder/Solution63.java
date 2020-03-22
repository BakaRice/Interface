package nowcoder;

import java.util.Stack;

/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
abce
sfcs
adee
矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution63 {
    boolean judge = false;
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, 1, 0, -1};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str.length == 0 || matrix.length == 0) return false;
        char map[][] = new char[rows][cols];
        boolean jud[][] = new boolean[rows][cols];
        for (int i = 0; i < matrix.length; i++)
            map[i / cols][i % cols] = matrix[i];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == str[0]) {
                    dfs(map, jud, i, j, 0, str);
                    if (judge) return true;
                }
            }
        }
        return judge;
    }

    private void dfs(char[][] map, boolean[][] jud, int m, int n, int index, char[] str) {
        if (index == str.length - 1) {
            if (map[m][n] == str[index]) judge = true;
        }//有成功的
        else if (map[m][n] != str[index]) return;//回溯停止
        else {
            jud[m][n] = true;
            for (int i = 0; i < 4; i++) {
                if (m + x[i] >= 0 &&
                        m + x[i] < map.length &&
                        n + y[i] >= 0 &&
                        n + y[i] < map[0].length &&
                        map[m + x[i]][n + y[i]] == str[index + 1]) {
                    if (!jud[m + x[i]][n + y[i]]) {
                        dfs(map, jud, m + x[i], n + y[i], index + 1, str);
                    }
                }
            }
            jud[m][n] = false;
        }
    }

}
