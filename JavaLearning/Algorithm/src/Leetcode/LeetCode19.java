package Leetcode;

import java.nio.file.Path;

public class LeetCode19 {

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int fnum = 0;
        int snum = 0;
        int sum = 0;
        if (head == null) return head;
        if (head != null && head.next == null && n == 1) return null;
        ListNode temp = head;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode f = head;
        ListNode s = head;
        while (f.next != null) {
            if (f.next != null && f.next.next == null) {//f后只有一个node 了
                f = f.next;
                fnum++;
            } else if (f.next.next != null) {
                f = f.next.next;
                fnum += 2;
            }
            if (s.next != null) {
                s = s.next;
                snum++;
            }
        }
        sum = fnum;
        //pre.next = head;
        while ((sum - n + 1) > snum) {
            pre = s;
            s = s.next;
            temp = s;
            snum++;
            if ((sum - n + 1) == snum) {
                if (s == null) pre.next = null;
                else
                    pre.next = s.next;
                return head;
            }
        }
        while (sum - n + 1 <= snum) {
            snum = 0;
            s = head;
            if (sum - n + 1 == 0) return head.next;
            while (sum - n + 1 > snum) {
                pre = s;
                s = s.next;
                temp = s;
                snum++;
                if ((sum - n + 1) == snum) {
                    pre.next = s.next;
                    return head;
                }
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode s = pre;
        ListNode f = pre;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f.next != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        LeetCode19 l = new LeetCode19();
        l.removeNthFromEnd(listNode1, 1);
    }
}
