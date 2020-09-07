package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class LeetCode138 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //利用哈希表来重复存储
    public Node copyRandomList(Node head) {
        Map<Node, Node> hp = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            hp.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        Node pre = new Node(0);
        curr = head;
        pre.next = curr;
        while (curr != null) {
            Node newNode = hp.get(curr);
            if (curr.next != null) {
                newNode.next = hp.get(curr.next);
            }
            if (curr.random != null) {
                newNode.random = hp.get(curr.random);
            }
            curr = curr.next;
        }
        return hp.get(head);
    }
}
