package Leetcode;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        helper(root.left, root.right);
        return root;
    }

    //递归写法
    private void helper(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null) return;
        leftNode.next = rightNode;
        helper(leftNode.left, leftNode.right);
        helper(leftNode.right, rightNode.left);
        helper(rightNode.left, rightNode.right);
    }


    //非递归写法
    public Node connect_2(Node root) {
        if (root == null) return root;
        Node pre = root;
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }

}
