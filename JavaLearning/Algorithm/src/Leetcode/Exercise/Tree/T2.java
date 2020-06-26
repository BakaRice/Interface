package Leetcode.Exercise.Tree;

import Leetcode.Exercise.String.T7;

import java.util.Stack;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 20:46
 */
public class T2 {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归解法
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        if (node.val <= minValue || node.val >= maxValue)
            return false;
        return validate(node.left, minValue, node.val)
                &&
                validate(node.right, node.val, maxValue);
    }

    //非递归的栈方式 二叉搜索树就是中序升序的
    public boolean isValidBST_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    //非递归方式的未优化解法，优化后为2
    public boolean isValidBST_3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
        }
        return true;
    }

}
