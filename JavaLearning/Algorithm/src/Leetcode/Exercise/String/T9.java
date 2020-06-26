package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 12:42
 */
public class T9 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";
        //以第一个string作为参照str，寻找最长前缀
        char[] com_ch = strs[0].toCharArray();
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            char[] curr_str = strs[i].toCharArray();
            int curr_index = 0;
            for (int j = 0; j < curr_str.length && j < com_ch.length; j++) {
                if (com_ch[j] == curr_str[j]) curr_index++;
                else break;
            }
            index = Math.min(index, curr_index);
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        T9 t9 = new T9();
        System.out.println(t9.longestCommonPrefix(new String[]{"c", "acc", "ccc"}));
    }
//    {  String longest = new String();
//        int flag = 0;
//        int i = 0;
//        if (strs==null||strs.length==0||(strs.length==1&&strs[0].length()==0))
//            return longest;
//        for (i = 0; i < strs[0].length(); i++) {
//            if (flag != 0)
//                break;
//            for (int j = 1; j < strs.length; j++) {
//                if (strs[j].length() == i) {
//                    flag = 1;
//                    break;
//                } else if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (i==0)
//            return longest;
//        longest = strs[0].substring(0, i - 1);
//        return longest;
//    }
}
