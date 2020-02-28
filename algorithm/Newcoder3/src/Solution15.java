public class Solution15 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode temp = head;
        ListNode tempNext = head.next;
        temp.next = null;
        while (tempNext.next != null) {
            ListNode tempNextNext = tempNext.next;
            tempNext.next = temp;


            temp = tempNext;
            tempNext = tempNextNext;

        }
        tempNext.next = temp;
        return tempNext;
    }


    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        ListNode l1 = new ListNode(11);
//        ListNode l2 = new ListNode(22);
//        ListNode l3 = new ListNode(33);
//        ListNode l4 = new ListNode(44);
//        ListNode l5 = new ListNode(55);
//
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        System.out.println(solution15.ReverseList(l1));
    }
}
