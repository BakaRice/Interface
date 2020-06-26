package Leetcode.Exercise.Linked_list;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 14:58
 */
public class T3 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL

    //递推的方式
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    //递归的方式
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList_2(head.next);
        head.next.next = head;
        //head.next表示原本的下一个结点 上句即为下一结点的next为当前节点，即前后互换
        head.next = null;
        return p;
    }



    public static void main(String[] args) {
        T3 t3 = new T3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        t3.reverseList_2(node1);
    }
}
