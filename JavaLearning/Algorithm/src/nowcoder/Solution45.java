package nowcoder;

/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution45 {
    public int Sum_Solution(int n) {
        //发散思维，&&的短路性质 如果前面是假 则根本不会计算后面的
        boolean flag = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
