package nowcoder;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Solution39 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int fsum = sum * 2;

        if (sum == 3) {
            ArrayList<Integer> list3 = new ArrayList<>();
            list3.add(1);
            list3.add(2);
            arrayLists.add(list3);
        }
        if (sum < 6) return arrayLists;
        for (int i = 0; i < 100; i++)
            for (int j = i; j < 100; j++) {//这里的100有问题 后期还要改
                int i1 = j * (j + 1) - i * (i + 1);
                if (i1 == fsum && i+1 != j) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int p = i + 1; p <= j; p++)
                        list.add(p);
                    arrayLists.add(list);
                    System.out.println(j + "-->" + (i + 1));
                }
                if (i1 > fsum)
                    break;
            }
        return arrayLists;
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        solution39.FindContinuousSequence(9);
    }
}
