package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/5/31 13:57
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class T4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0||matrix[0].length==0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
