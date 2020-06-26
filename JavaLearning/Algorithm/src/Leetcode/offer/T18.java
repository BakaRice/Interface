package Leetcode.offer;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/10 21:07
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class T18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            }
            prev = head;
            head = head.next;
        }
        return sentinel.next;
    }
}
