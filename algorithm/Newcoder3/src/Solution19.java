import java.util.ArrayList;

/**
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 从外向里以顺时针的顺序依次打印出每一个数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int wlen = matrix[0].length;
        int hlen = matrix.length;
        int sw = 0, sh = 1;
        int i = 0, j = 0;
        int min = Math.min(wlen,hlen);
        for(int p=0;p<(min+1)/2;i++) {

            for (i = sw; i < wlen - sw; i++) {
                System.out.print(matrix[sw][i] + " ");
                list.add(matrix[sw][i]);

            }
            for (j = sh; j < hlen - sh; j++) {
                System.out.print(matrix[j - sw][wlen - 1] + " ");
                list.add(matrix[j - sw][wlen - 1]);
            }
            for (i = wlen - sw - 1; i >= sw; i--) {
                System.out.print(matrix[j][i] + " ");
                list.add(matrix[j][i]);
            }
            for (j = hlen - sh - 1; j >= sh; j--) {
                System.out.print(matrix[j][sw] + " ");
                list.add(matrix[j][sw]);
            }
            sh++;
            sw++;
        }
        System.out.println("sh:" + sh + "sw:" + sw);
//        if ((wlen%2==1)&&(hlen%2==1))
//            System.out.println(matrix[sh-1][sw]);
        return list;
    }

    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] mx = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] mx2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mx3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[][] mx4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        Solution19 solution19 = new Solution19();
        solution19.printMatrix2(mx3);
    }
}