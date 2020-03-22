package nowcoder;

import java.util.ArrayList;
import java.util.List;

/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution31 {
    public int GetUglyNumber_Solution(int index) {
        //分治+贪心的思想 每一个2、3、5独立下标 向右移动
        //使用原生的速度会更快
        if (index<7) return index;
        int[] a = new int[index];
        a[0] = 1;
        int f2 = 0, f3 = 0, f5 = 0;
        for (int i = 0; i < index - 1; i++) {
            int fl2=0,fl3=0,fl5=0;
            if (a[f2] * 2 <= a[f3] * 3 && a[f2] * 2 <= a[f5] * 5) {
                a[i + 1] = a[f2] * 2;
                fl2=1;
            }
            if (a[f3] * 3 <= a[f5] * 5 && a[f3] * 3 <= a[f2] * 2) {
                a[i + 1] = a[f3] * 3;
                fl3=1;
            }
            if (a[f5] * 5 <= a[f3] * 3 && a[f5] * 5 <= a[f2] * 2) {
                a[i + 1] = a[f5] * 5;
                fl5=1;
            }
            if (fl2==1) f2++;
            if (fl3==1) f3++;
            if (fl5==1) f5++;
        }
        return a[index - 1];
        //调用速度会慢 但可读性更强
//        int a2=0,a3=0,a5=0;
//        if(index<7)return index;//小于7都是
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        for(int i=1;i<index;i++)
//        {
//            int min=Math.min(list.get(a2)*2, Math.min(list.get(a3)*3, list.get(a5)*5));
//            list.add(min);
//            if(min==list.get(a2)*2)a2++;
//            if(min==list.get(a3)*3)a3++;
//            if(min==list.get(a5)*5)a5++;
//        }
//        return list.get(index-1);

    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        System.out.println(solution31.GetUglyNumber_Solution(8));
    }
}
