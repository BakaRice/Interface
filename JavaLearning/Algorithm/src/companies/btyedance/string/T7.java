package companies.btyedance.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 22:29
 */
public class T7 {
    LinkedList<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        backtrack(s, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(String s, int i, LinkedList<String> track) {
        if (track.size() > 4 || i > s.length()) return;
        if (i == s.length() && track.size() == 4) {
            res.add(String.join(".", track));
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (i + j > s.length())
                break;
            String segment = s.substring(i, i + j);
            if (segment.equals("")) return;
            int curr = Integer.valueOf(segment);
            if (segment.startsWith("0") && segment.length() > 1 ||
                    (j == 3 && curr > 255)) continue;
            track.add(segment);
            backtrack(s, i + j, track);
            track.removeLast();

        }
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        t7.restoreIpAddresses("010010").forEach(System.out::println);
    }
}
