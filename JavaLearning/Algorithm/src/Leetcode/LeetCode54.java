package Leetcode;

/*
https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/submissions/

对于这种打印题，主要的思想就是模拟这个过程，可以记录每一个的方向的当前最大长度和起始位置。
每个方向的遍历完成后 更改该方向上的最大长度和起始位置

 */
public class LeetCode54 {
//    第一次写的时候的一个慢的思想 就是每次替换 以此达到确认是否到达边界 这样的时间复杂度会更高
//    所以我们应该想一个 不用每次进行替换同时能够探寻边界的方式，即每个方向上的遍历完成后就重新赋值该方向上的边界，确立其起始和终止位置
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0) return new int[0];
        int clen = matrix.length;
        int rlen = matrix[0].length;
        int[] ans = new int[clen * rlen];
        int i = 0, j = 0, cur = 0;
        ans[0] = matrix[0][0];
        cur++;
        matrix[0][0] = Integer.MIN_VALUE;
        while (true) {
            j++;
            //从左向右
            while (true) {
                if (i >= 0 && j >= 0 && i < clen && j < rlen && matrix[i][j] != Integer.MIN_VALUE) {
                    ans[cur] = matrix[i][j];
                    matrix[i][j] = Integer.MIN_VALUE;
                    j++;
                    cur++;
                } else {
                    j--;
                    break;
                }
            }
            i++;
            //从上到下
            while (true) {
                if (i >= 0 && j >= 0 && i < clen && j < rlen && matrix[i][j] != Integer.MIN_VALUE) {
                    ans[cur] = matrix[i][j];
                    matrix[i][j] = Integer.MIN_VALUE;
                    i++;
                    cur++;
                } else {
                    i--;
                    break;
                }
            }
            j--;
            //从右到左
            while (true) {
                if (i >= 0 && j >= 0 && i < clen && j < rlen && matrix[i][j] != Integer.MIN_VALUE) {
                    ans[cur] = matrix[i][j];
                    matrix[i][j] = Integer.MIN_VALUE;
                    j--;
                    cur++;
                } else {
                    j++;
                    break;
                }
            }
            i--;
            //从下到上
            while (true) {
                if (i >= 0 && j >= 0 && i < clen && j < rlen && matrix[i][j] != Integer.MIN_VALUE) {
                    ans[cur] = matrix[i][j];
                    matrix[i][j] = Integer.MIN_VALUE;
                    i--;
                    cur++;
                } else {
                    i++;
                    break;
                }
            }
            if (cur == ans.length) break;
        }
        return ans;
    }

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int curr = 0;
        while (true) {
            for (int i = l; i <= r; i++) res[curr++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[curr++] = matrix[i][r];
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[curr++] = matrix[b][i];
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[curr++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] is = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        LeetCode54 leetCode54 = new LeetCode54();
        System.out.println(leetCode54.spiralOrder(is));
    }
}