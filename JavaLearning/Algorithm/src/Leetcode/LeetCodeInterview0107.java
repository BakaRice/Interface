package Leetcode;

public class LeetCodeInterview0107 {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix[0].length - 1 - i];
                matrix[matrix.length - 1 - j][matrix[0].length - 1 - i] = temp;
            }
        }
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCodeInterview0107 leetCodeInterview0107 = new LeetCodeInterview0107();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        leetCodeInterview0107.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
