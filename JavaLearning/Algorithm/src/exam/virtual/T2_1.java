package exam.virtual;

/**
 * @author RiceFamily
 * @date 2020/6/3 10:14
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class T2_1 {
    public String reverseStr(String s, int k) {
        if (k == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 2 * k) {
            String swap = swap(s, i, i + k - 1);
            sb.append(swap);
            if (i + 2 * k < s.length())
                sb.append(s, i + k, i + 2 * k);
            else if (i + k < s.length())
                sb.append(s, i + k, s.length());

        }
        return sb.toString();
    }

    private String swap(String s, int start, int end) {
        //超过长度时 即改为改长度
        if (end > s.length() - 1) end = s.length() - 1;
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int ts = start;
        int te = end;
        while (start < end) {
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
        for (int i = ts; i <= te; i++) {
            sb.append(cs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T2_1 t2 = new T2_1();
        System.out.println(t2.reverseStr("a", 2));
    }
}
