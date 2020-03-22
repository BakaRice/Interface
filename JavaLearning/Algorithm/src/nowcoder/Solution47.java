package nowcoder;

/*
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Solution47 {
    /**
     * 要记得考虑字符串长度为零的情况，为零和为null是不同的
     * 记得题目中说的是整数 不能超过int范围
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int multiplier = 1;
        int sum = 0;
        if (str.charAt(0) == '-') multiplier = -1;
        else if (str.charAt(0) == '+') {
            multiplier = 1;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 48 && c <= 57) {
                int ci = c - 48;
                if (Integer.MAX_VALUE / 10 == sum && ci > 8)
                    return 0;
                else if (Integer.MAX_VALUE / 10 == sum && ci >7 && multiplier == 1)
                    return 0;
                sum = sum * 10 + ci;
            } else if (i != 0)
                return 0;

        }
        sum *= multiplier;
        return sum;
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.StrToInt("2147483647"));
    }
}
