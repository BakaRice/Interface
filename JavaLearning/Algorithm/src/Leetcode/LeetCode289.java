package Leetcode;

/**
 * https://leetcode-cn.com/problems/game-of-life/
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode289 {

    int dx[] = {0, 0, -1, 1, 1, -1, 1, -1};
    int dy[] = {1, -1, 0, 0, 1, -1, -1, 1};

    public void gameOfLife(int[][] board) {
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int sum = 0;
                for (int d = 0; d < 8; d++) {
                    int x = i + dx[d], y = j + dy[d];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                    else if (copyBoard[x][y] == 1) sum++;
                }
                if (sum == 3) board[i][j] = 1;
                else if (sum < 2 || sum > 3) board[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode289 leetCode289 = new LeetCode289();
        int[][] x = {{0,0}};
        leetCode289.gameOfLife(x);
    }
    /*
    {0, 1, 0},
    {0, 0, 1},
    {1, 1, 1},
    {0, 0, 0}
     */
}
