package Leetcode;

public class LeetCode02 {

    //Definition for singly-linked list.

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 2 4 3
     * 5 6
     */
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode temp = new ListNode(0);
         ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
//创建链表1
        temp = l1;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
//创建链表2
        temp = l2;
        temp.next = new ListNode(0);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        LeetCode02 leetCode02 = new LeetCode02();
        ListNode temp2 = leetCode02.addTwoNumbers(l1, l2);
        while (temp2.next!=null){
            System.out.println(temp2.val);
            temp2 = temp2.next;
        }
        System.out.println(temp2.val);
    }

}
