package companies.didi;

import java.util.Scanner;

/*
求末尾几个0，就看这个数有几个10因子，10=5*2，
但是最后得到的结果2的个数一定多于5的个数，
所以只需要求5的个数就可以了。
但是就像25这种数字，它可以被5除两次，
所以我们要在循环中除以5，最后把除5的个数累加就可以了。
 */
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num5 = 0;
        for (int i = 1; i <= n; i++) {
            n = n / 5;
            num5 = num5 + n;
        }
        System.out.println(num5);
    }
}
