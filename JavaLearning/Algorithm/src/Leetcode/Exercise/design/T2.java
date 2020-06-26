package Leetcode.Exercise.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 20:33
 */
public class T2 {
    class MinStack {

        Deque<Integer> sk;
        Deque<Integer> help_sk;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            sk = new ArrayDeque<Integer>();
            help_sk = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            sk.addLast(x);
            if (help_sk.isEmpty()) help_sk.addLast(x);
            else
                help_sk.addLast(Math.min(x, help_sk.peekLast()));
        }

        public void pop() {
            sk.pollLast();
            help_sk.pollLast();
        }

        public int top() {
            return sk.peekLast();
        }

        public int getMin() {
            return help_sk.peekLast();
        }
    }
}
