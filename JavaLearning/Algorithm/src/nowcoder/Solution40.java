package nowcoder;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

import java.util.ArrayList;

public class Solution40 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int l = 0, r = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (l < r) {
            if (array[l] + array[r] == sum) {
                list.add(array[l]);
                list.add(array[r]);
                break;
            } else if (array[l] + array[r] < sum)
                l++;
            else if (array[l] + array[r] > sum)
                r--;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] a = {1, 2, 4, 7, 11, 15};
        System.out.println(solution40.FindNumbersWithSum(a, 15));
    }
}