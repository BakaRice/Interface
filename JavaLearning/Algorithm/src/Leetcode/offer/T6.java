package Leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author RiceFamily
 * @date 2020/5/31 14:12
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class T6 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.addLast(curNode.val);
            curNode = curNode.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
