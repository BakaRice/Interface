package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/5/31 14:07
 */
public class T5 {
    public String replaceSpace(String s) {
//        return s.replace(" ","%20");
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
