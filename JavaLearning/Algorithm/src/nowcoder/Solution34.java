package nowcoder;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution34 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = getlen(pHead1);
        int len2 = getlen(pHead2);
        while (len1 > len2) {
            pHead1 = pHead1.next;
            len1--;
        }
        while (len1 < len2) {
            pHead2 = pHead2.next;
            len2--;
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;

        }
        return pHead1;
    }

    int getlen(ListNode node) {
        int len = 0;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
