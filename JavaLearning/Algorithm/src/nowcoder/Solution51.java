package nowcoder;

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution51 {
    public boolean isNumeric(char[] str) {
        if (str.length == 0 || str == null) return false;
        int flag1 = 0;//E前的小数点次数
        int afterE = 0;//到达E位置的标记
        int ei = 0;//E后的位数
        for (int i = 0; i < str.length; i++) {
            if (str[i] < 48 || str[i] > 57) {
                if (str[i] == '+' || str[i] == '-') {
                    if (i == 0) continue;
                    if (str[i - 1] == 'E'|| str[i-1] == 'e') continue;
                }
                if (str[i] == 'E' || str[i] == 'e') {
                    afterE = 1;
                    continue;
                }
                if (str[i] == '.' && flag1 == 0 && afterE == 0) {
                    flag1 = 1;
                    continue;
                }
                return false;
            }else
            if (afterE == 1) ei++;
        }
        if (ei == 0 && afterE == 1) return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        char[] c = {'1', '2', '3', '.', '4','5','e','+','6'};
        System.out.println(solution51.isNumeric(c));
        //123.45e+6
    }
}