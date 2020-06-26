package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 12:09
 */
public class T8 {
    public String countAndSay(int n) {
//        1 -> 11
//        11 -> 21
//        21 -> 1211
        if (n == 1) return "1";
        if (n == 2) return "11";
        if (n == 3) return "21";
        if (n == 4) return "1211";
        if (n == 5) return "111221";
        String res = "111221";
        if (n > 5) {
            while (n > 5) {
                StringBuilder sb = new StringBuilder();
                char[] cs = res.toCharArray();
                for (int i = 0; i < cs.length; ) {
                    int left = i, right = i + 1;
                    while (right < cs.length && cs[left] == cs[right]) {
                        right++;
                    }
                    sb.append((right - left));
                    sb.append(cs[left]);
                    i = right;
                }
                res = sb.toString();
                n--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T8 t8 = new T8();
        t8.countAndSay(7);
    }
}
