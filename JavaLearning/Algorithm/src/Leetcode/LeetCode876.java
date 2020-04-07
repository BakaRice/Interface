package Leetcode;


import java.util.ArrayList;


/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode876 {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        int cur = 1;
        if (head != null)
            listNodes.add(head);
        while (head.next != null) {
            head = head.next;
            listNodes.add(head);
            cur++;
        }
        if (cur == 1 || cur == 0) return head;
        int mid = cur / 2;
        return listNodes.get(mid);
    }

    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
