package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int prev = Integer.MIN_VALUE;
    boolean flag = true;

    //递归写法
    public boolean isValidBST_recursive(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            boolean validBSTleft = isValidBST_recursive(root.left);
            if (!validBSTleft) return false;
        }

        if (flag) {
            prev = root.val;
            flag = false;
        } else if (prev >= root.val) return false;
        prev = root.val;

        if (root.right != null) {
            boolean validBSTright = isValidBST_recursive(root.right);
            if (!validBSTright) return false;
        }
        return true;
    }

    //栈写法 中序遍历
    public boolean isValidBST_stack(TreeNode root) {
        int prev = 0;
        boolean flag = true;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return true;
        else if (root != null) stack.push(root);
        TreeNode node = stack.peek();
        while (node.left != null) {
            node = node.left;
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            if (flag) flag = false;
             else if (prev >= node1.val) return false;
            prev = node1.val;
//            System.out.println(node1.val + " ");
            if (node1.right != null) {
                node1 = node1.right;
                stack.push(node1);
                while (node1.left != null) {
                    node1 = node1.left;
                    stack.push(node1);
                }
            }
        }
        return false;
    }

    public boolean isValidBST_stack2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode98 leetCode98 = new LeetCode98();
        System.out.println(leetCode98.isValidBST_stack(new TreeNode(Integer.MIN_VALUE)));
    }
}
