package Leetcode.Exercise.Linked_list;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 13:09
 */
public class T1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
//        ListNode dummy = new ListNode(-1);
//        dummy.next = node;
//        ListNode curr = node;
//        ListNode prev = dummy;
//        while (curr.next != null) {
//            //仅把后一个的值移动到前面
//            curr.val = curr.next.val;
//            prev = curr;
//            curr = curr.next;
//        }
//        //删除最后一个节点
//        prev.next = null;
    }
}
