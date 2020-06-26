package Leetcode.Exercise.math;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 20:44
 * https://leetcode-cn.com/problems/fizz-buzz/solution/fizz-buzz-by-leetcode/
 * 散列表的思想确是好
 */
public class T1 {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if (i % 3 == 0)
                list.add("Fizz");
            else if (i % 5 == 0)
                list.add("Buzz");
            else list.add(Integer.valueOf(i).toString());
        }
        return list;
    }
}
