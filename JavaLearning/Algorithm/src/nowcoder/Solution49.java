package nowcoder;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。
（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */

import java.util.ArrayList;

public class Solution49 {

    //分为左右的思想 注意循环的范围 等情况时的条件
    public int[] multiply(int[] A) {
        int len = A.length;
        int B[] = new int[len];
        int left[] = new int[len];
        int right[] = new int[len];
        left[0] = 1;
        right[len - 1] = A[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * A[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i];
        }
        B[0] = right[1];
        B[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            B[i] = left[i - 1] * right[i + 1];
        }
        return B;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(solution49.multiply(a).toString());
    }
}