package nowcoder;

import java.util.HashMap;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出这两个只出现一次的数字。
 */
public class Solution38 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor1 = 0;
        for (int i = 0; i < array.length; i++)
            xor1 = xor1 ^ array[i];
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while ((index & xor1) == 0)
            index = index << 1;//因为可能有多个位为1所以需要求一下位置
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0)
                result1 = result1 ^ array[i];
            else
                result2 = result2 ^ array[i];
        }
        num1[0] = result1;
        num2[0] = result2;
    }

    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], 2);
            else
                map.put(array[i], 1);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else
                    num2[0] = array[i];
            }
        }
    }


    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        int[] a = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] b = new int[1], c = new int[1];
        solution38.FindNumsAppearOnce(a, b, c);
    }
}
