package Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isSubtree = false;
        queue.add(s);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == t.val)
                isSubtree = isSubtree_rev(poll, t);
            if (isSubtree) return isSubtree;//if t is the subtree return
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        return isSubtree;
    }

    private boolean isSubtree_rev(TreeNode poll, TreeNode t) {
        if (poll == null && t == null) return true;
        if (poll == null || t == null) return false;
        if (poll.val == t.val) {
            return isSubtree_rev(poll.right, t.right) && isSubtree_rev(poll.left, t.left);
        } else return false;
    }
}
