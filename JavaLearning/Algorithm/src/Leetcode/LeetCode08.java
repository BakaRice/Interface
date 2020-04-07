package Leetcode;

public class LeetCode08 {
    /*
    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。
     */
    public int myAtoi1(String str) {
        str = str.trim();//忽略前后空白
        int sum = 0;
        //System.out.print(str);
        int i = 0;
        int flag = 0;
        boolean flag2 = true;
        if (str.length() == 0) return 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-' || (str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                i = 1;
                if (str.charAt(0) == '-') flag = 1;
                if (str.length() == 1) flag2 = false;
            }
            while (flag2) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int p = (int) (str.charAt(i) - '0');
                    if (flag == 1) p = -p;//如果是负数
                    if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && p > Integer.MAX_VALUE % 10))
                        return Integer.MAX_VALUE;
                    if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && p < Integer.MIN_VALUE % 10))
                        return Integer.MIN_VALUE;
                    sum = sum * 10 + p;
                    i++;
                    if (i == str.length())
                        break;
                } else
                    break;
            }

        }
        return sum;
    }


    public int myAtoi(String str) {
        int res = 0;
        int i = 0;
        int flag = 1;
        while (str.charAt(i) == ' ') {
            i++;
        }
        if (str.charAt(i) == '-') flag = -1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') i++;
        while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            int r = str.charAt(i)-'0';
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&& r>7)){
                return  flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+r;
            i++;
        }
        return  flag>0?res:-res;
    }

    public static void main(String[] args) {
        LeetCode08 leetCode08 = new LeetCode08();
        System.out.println(leetCode08.myAtoi("2147483648"));
    }
}
