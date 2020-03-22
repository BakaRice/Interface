package nowcoder;

import java.util.ArrayList;

/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution62 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) return list;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int index = 0;
        if (size > num.length) return list;
        for (int i = start; i < start + size; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        list.add(num[index]);
        for (int j = size; j < num.length; j++) {
            if (index < j - size + 1) {
                index = -1;
            }
            if (index == -1) {
                max = Integer.MIN_VALUE;
                for (int i = j - size + 1; i <= j; i++) {
                    if (num[i] > max) {
                        max = num[i];
                        index = i;
                    }
                }
            }
            int temp = num[j];
            if (temp > max) {
                index = j;
                max = temp;
                list.add(num[index]);
            } else
                list.add(num[index]);
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows2(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) return list;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int index = -1;
        if (size > num.length) return list;
        for (int j = 0; j < num.length - size + 1; j++) {
            if (index < j) {
                index = -1;
            }
            if (index == -1) {
                max = Integer.MIN_VALUE;
                for (int i = j; i < j + size; i++) {
                    if (num[i] > max) {
                        max = num[i];
                        index = i;
                    }
                }
            }
            int temp = num[j + size - 1];
            if (temp > max) {
                index = j + size - 1;
                max = temp;
                list.add(num[index]);
            } else
                list.add(num[index]);
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows3(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (size == 0) return list;
        int len = num.length;
        while (size-- > 1) {
            for (int i = 0; i < len - 1; i++) {
                num[i] = Math.max(num[i], num[i + 1]);
            }
            len--;
        }
        System.out.println(len);

        for (int i = 0; i < len; i++) {
            list.add(num[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(solution62.maxInWindows3(num, 3));
    }


}
