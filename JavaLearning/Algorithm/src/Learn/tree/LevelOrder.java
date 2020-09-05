package Learn.tree;

import java.util.*;

//二叉树的层次遍历
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class LevelOrder {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //仅仅使用一个队列的骚操作层次遍历 记录每层的数量
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode pollNode = queue.poll();
                curr.add(pollNode.val);
                if (pollNode.left != null) queue.add(pollNode.left);
                if (pollNode.right != null) queue.add(pollNode.right);
            }
            res.add(curr);
        }
        return res;
    }

    //常规 整两个队列
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        List<Integer> curr = new ArrayList<>();

        if (root != null) queue.add(root);
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode pollNode = queue.poll();
                curr.add(pollNode.val);
                if (pollNode.left != null) queue2.add(pollNode.left);
                if (pollNode.right != null) queue2.add(pollNode.right);
            }
            if (curr.size() > 0) res.add(curr);
            curr = new ArrayList<>();
            while (!queue2.isEmpty()) {
                TreeNode pollNode = queue2.poll();
                curr.add(pollNode.val);
                if (pollNode.left != null) queue.add(pollNode.left);
                if (pollNode.right != null) queue.add(pollNode.right);
            }
            if (curr.size() > 0) res.add(curr);
            curr = new ArrayList<>();
        }
        return res;
    }
}
