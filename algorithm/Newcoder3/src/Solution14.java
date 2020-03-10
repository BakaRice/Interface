public class Solution14 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        int length = 1;
        ListNode temphead = head;
        while (temphead.next != null) {
            length++;
            temphead = temphead.next;
        }
        temphead = head;
        ListNode[] listNodes = new ListNode[length];
        int i = 0;
        while (temphead.next != null) {
            listNodes[i] = temphead.next;
            temphead = temphead.next;
            i++;
        }
        if (length - k == 0) return head;
        else if (length - k < 0) return null;
        return listNodes[length - k - 1];
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        ListNode l1 = new ListNode(100);
        //ListNode l2 = new ListNode(22);
        //ListNode l3 = new ListNode(33);
        //l1.next = l2;
        //l2.next = l3;

        System.out.println(solution14.FindKthToTail(null, 1).val);
    }

}
