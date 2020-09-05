package Learn.tree;

import java.util.*;

public class PreorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ans = new ArrayList<>();

    //最简单的递归遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        else ans.add(root.val);
        if (root.left != null)
            preorderTraversal(root.left);
        if (root.right != null)
            preorderTraversal(root.right);
        return ans;
    }

    //非递归 前序遍历二叉树 入栈时 先入栈右子树 后入栈左子树，出栈时将值输出。
    public List<Integer> preorderTraversal_2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ans.addLast(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return ans;
    }
}
