package nowcoder;

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

import java.util.ArrayList;

public class Solution53 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead.next == null || pHead == null) return null;
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode tempNode = new ListNode(pHead.val);
        tempNode.next = pHead.next;
        nodes.add(pHead);
        while (tempNode.next != null) {
            if (nodes.contains(tempNode.next)) return tempNode.next;
            else
                nodes.add(tempNode.next);
            tempNode = tempNode.next;
        }
        return null;
    }

    //快慢指针 追赶 第一次相遇后 快指针回到头，两个以相同速度前进 相遇时即为头
    public ListNode EntryNodeOfLoop2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
