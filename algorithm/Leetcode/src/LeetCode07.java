import java.lang.annotation.ElementType;

public class LeetCode07 {
    // [−2^31,  2^31 − 1]
    //翻转后溢出 则返回0
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop >Integer.MAX_VALUE%10)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop <Integer.MIN_VALUE%10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        LeetCode07 leetCode07 = new LeetCode07();
        System.out.print(leetCode07.reverse(2147483647));
    }
}
