import java.util.ArrayList;

public class Solution13 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        int oddnum  = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)//如果是偶数
                list.add(array[i]);
            else if (array[i] % 2 != 0) {//如果是奇数
                list.add(oddnum, array[i]);
                oddnum++;
            }
        }
        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i);
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int array[] = new int[]{1, 2, 3, 4, 5, 6};
        solution13.reOrderArray(array);
    }
}
