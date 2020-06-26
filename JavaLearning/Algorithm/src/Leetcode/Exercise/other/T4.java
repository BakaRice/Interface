package Leetcode.Exercise.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/6/26 18:30
 */
public class T4 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>() {{
            add(1);
        }});
        if (numRows == 1) return res;
        res.add(new ArrayList<>() {{
            add(1);
            add(1);
        }});
        if (numRows == 2) return res;
        for (int i = 2; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> pre = res.get(res.size() - 1);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(pre.get(j) + pre.get(j - 1));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.generate(5);
    }
}
