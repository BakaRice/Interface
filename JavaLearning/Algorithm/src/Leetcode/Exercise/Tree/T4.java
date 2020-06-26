package Leetcode.Exercise.Tree;

import java.util.*;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 22:26
 */
public class T4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode poll = queue.poll();
                curr.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(curr);
        }
        return res;
    }
}
