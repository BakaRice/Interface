public class Solution16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newNode = null, atemp = list1, btemp = list2;
        if (list1 == null && list2 != null) return list2;
        if (list2 == null && list1 != null) return list1;
        if (list1 == null && list2 == null) return null;
        if (list1.val > list2.val)//find the smaller number to start
        {
            newNode = list2;
            btemp = btemp.next;

        } else {
            newNode = list1;
            atemp = atemp.next;
        }
        ListNode rNode = newNode;
        while (atemp != null || btemp != null) {
            if (btemp == null && atemp != null) {
                newNode.next = atemp;
                atemp = atemp.next;
            } else if (atemp == null && btemp != null) {
                newNode.next = btemp;
                btemp = btemp.next;
            } else if (atemp.val > btemp.val) {//b node is the smaller num
                newNode.next = btemp;
                btemp = btemp.next;
            } else {
                newNode.next = atemp;
                atemp = atemp.next;
            }
            newNode = newNode.next;
        }
        return rNode;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        ListNode l1 = new ListNode(11);
        ListNode l2 = new ListNode(22);
        ListNode l3 = new ListNode(33);
        ListNode l4 = new ListNode(44);
        ListNode l5 = new ListNode(55);

        l1.next = l3;
        l2.next = l4;
        l3.next = l5;

        ListNode temp = solution16.Merge(null, l2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
