package dataStructure.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/7/22 12:52
 */
class MinStack {

    // 数据栈
    private LinkedList<Integer> data;
    // 辅助栈
    private LinkedList<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new LinkedList<>();
        helper = new LinkedList<>();
    }

    // 思路 1：数据栈和辅助栈在任何时候都同步

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peekLast() >= x) {
            helper.add(x);
        } else {
            helper.addLast(helper.peekLast());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.removeLast();
            data.removeLast();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.getLast();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.getLast();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}