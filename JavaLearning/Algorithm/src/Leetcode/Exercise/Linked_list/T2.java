package Leetcode.Exercise.Linked_list;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 13:42
 */
public class T2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = prev;
        ListNode findLast = prev;
        while (n > 0) {
            findLast = findLast.next;
            n--;
        }
        while (findLast.next != null) {
            prev = prev.next;
            curr = curr.next;
            findLast = findLast.next;
        }
        curr.next = curr.next.next;
        return prev.next;
    }
}
