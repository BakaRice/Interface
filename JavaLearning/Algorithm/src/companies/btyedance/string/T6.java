package companies.btyedance.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 16:24
 */
public class T6 {
    public String simplifyPath(String path) {
        Deque<String> sk = new ArrayDeque<>();
        char[] xs = path.trim().toCharArray();
        for (int i = 0; i < xs.length; ) {
            if (xs[i] == '/') {
                String curr = getDirName(path, xs, i);
                if (curr.equals("..") && !sk.isEmpty()) sk.pollLast();
                else if (curr.length() > 0 && !curr.equals(".")&&!curr.equals("..")) sk.addLast(curr);

                i += curr.length() + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (sk.isEmpty()) return "/";
        while (!sk.isEmpty()) {
            sb.append("/");
            sb.append(sk.pollFirst());
        }
        return sb.toString();
    }

    private String getDirName(String path, char[] xs, int i) {
        int end = i + 1;
        while (end < xs.length && xs[end] != '/') {
            end++;
        }
        return path.substring(i + 1, end);
    }

    public static void main(String[] args) {
        T6 t6 = new T6();
        System.out.println(t6.simplifyPath("/a/./b/../../c/"));
    }
}
