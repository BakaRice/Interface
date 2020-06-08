package Leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author RiceFamily
 * @date 2020/6/1 8:56
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class T9 {
    class CQueue {

        //官方已经不建议使用stack
        Deque<Integer> stk,stk1;

        public CQueue() {
            stk = new LinkedList<>();
            stk1 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stk.addLast(value);
        }

        public int deleteHead() {
            if (stk1.isEmpty()) {
                while (!stk.isEmpty()) {
                    stk1.addLast(stk.removeLast());
                }
            }
            return stk1.isEmpty() ? -1 : stk1.removeLast();
        }
    }
}
