package Leetcode;

import java.util.ArrayList;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode62interview {
    public int lastRemaining(int n, int m) {
        int p = n;
        boolean[] bn = new boolean[n];
        int cur = 0;
        int temp = 0;
        while (p > 0) {
            if (bn[cur] == false) {
                if (temp == m-1) {
                    temp = 0;
                    bn[cur] = true;
                    p--;
                }else
                temp = temp + 1;
                // cur = (cur + 1) % n;
            }
            cur = (cur + 1) % n;
        }
        return (cur-1+n)%n;
    }
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0;i<n;i++){
            list.add(i);
        }
        int idx = 0;
        while (n>0){
            idx = (idx+m-1)%n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        LeetCode62interview leetCode62interview = new LeetCode62interview();
        System.out.println(leetCode62interview.lastRemaining(5, 3));
        ;
    }
}
