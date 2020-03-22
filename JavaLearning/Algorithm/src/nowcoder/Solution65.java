package nowcoder;

/*
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution65 {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        int timeOf3 = target / 3;
        if (target - timeOf3 * 3 == 1) {//剩余长度为4
            timeOf3 -= 1;
        }
        int timeOf2 = (target - timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));

    }
    public int cutRope2(int target) {
       // int a[]= {1,4,27,128};//1 2*2  3*3*3  4*4*4     2-7分两个     7-27分3    27-60分3或者4尝试
        if(target<=7)
            return (target/2)*(target-target/2);
        else if (target<=27) {
            return (target/3)*((target+1)/3)*((target+2)/3);//看看余数要分配给几个数
        }
        else {
            return Math.max((target/3)*((target+1)/3)*((target+2)/3), (target/4)*((target+1)/4)*((target+2)/4)*((target+3)/4));
        }
    }
}




