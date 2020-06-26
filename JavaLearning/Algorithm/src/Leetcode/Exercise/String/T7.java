package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 10:31
 */
public class T7 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        char[] ha = haystack.toCharArray();
        char[] na = needle.toCharArray();
        int index = -1;
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0 || (haystack.length() < needle.length())) return index;
        for (int i = 0; i < ha.length; i++) {
            if (ha[i] == na[0]) {
                index = i;
                //这里的for循环判断条件要求 i+j，j都能满足不越界需求
                for (int j = 0; i+j < ha.length && j < na.length && ha[i + j] == na[j]; j++) {
                    if (j == na.length - 1) return index;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        System.out.println(t7.strStr("mississippi", "issipi"));
    }
//    "mississippi"
//            "issipi"
}
