package Leetcode;

import java.util.*;

/**
 * @author RiceFamily
 * @date 2020/5/12 20:33
 * https://leetcode-cn.com/problems/min-stack/
 */
public class LeetCode155 {
    class MinStack {

        List<Integer> list;
        PriorityQueue<Integer> queue;
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new LinkedList<>();
            queue = new PriorityQueue<>();
        }

        public void push(int x) {
            if (list.size() == 0) min = x;
            list.add(x);
            queue.add(x);
        }

        public void pop() {
            Integer top = list.get(list.size() - 1);
            if (list.size() > 0)
                list.remove(list.size() - 1);
            queue.remove(top);
        }

        public int top() {
            int topNum = 0;
            if (list.size() > 0) {
                topNum = list.get(list.size() - 1);
            }
            return topNum;
        }

        public int getMin() {
            return queue.peek();
        }
    }

    public class MinStack1 {

        // 数据栈
        private Stack<Integer> data;
        // 辅助栈
        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路 1：数据栈和辅助栈在任何时候都同步

        public void push(int x) {
            // 数据栈和辅助栈一定会增加元素
            data.add(x);
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            // 两个栈都得 pop
            if (!data.isEmpty()) {
                helper.pop();
                data.pop();
            }
        }

        public int top() {
            if(!data.isEmpty()){
                return data.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if(!helper.isEmpty()){
                return helper.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

}
