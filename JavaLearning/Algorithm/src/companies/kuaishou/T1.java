package companies.kuaishou;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        String str = s.next();
        char[] chars = str.toCharArray();
        int res = 0;
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') {
                res++;
            }
        }
        if (res < k) {
            System.out.println(0);
        }
        res = 0;
        for (int i = 0; i < len; i++) {
            /*滑动索引*/
            int index = i;
            int count = 0;
            while (count < k && index < len) {
                if (chars[index] == '1' && ++count == k) {
                    res++;
                    index++;
                    break;
                }
                index++;
            }
            /*满足k后继续右滑*/
            while (index < len && chars[index] != '1') {
                res++;
                index++;
            }
        }
        System.out.println(res);
    }

}