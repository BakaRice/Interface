package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/16 9:55
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class LeetCode25 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = next;
                cur = next;
                count++;
            }
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            return prev;
        } else
            return head;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode tail
                = dummy;

        while (tail.next != null) {
            for (int i = 0; i < k && tail != null; i++) tail = tail.next;
            if (tail == null) break;
            ListNode start = pre.next;
            ListNode next = tail.next;
            tail.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            tail = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
