package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RiceFamily
 * @date 2020/5/13 11:19
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LeetCode102 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        if (root == null) return lists;
        queue.add(root);
        list.add(root.val);
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            if (list.size() > 0)
                lists.add(new ArrayList<>(list));
            list.clear();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue2.add(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue2.add(poll.right);
                    list.add(poll.right.val);
                }

            }
            if (list.size() > 0)
                lists.add(new ArrayList<>(list));
            list.clear();
            while (!queue2.isEmpty()) {
                TreeNode poll = queue2.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    list.add(poll.right.val);
                }

            }
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            //用size记录每层的大小 巧妙的避免了 创建多个队列的情况
            while (size > 0) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                size--;
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode102 leetCode102 = new LeetCode102();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        leetCode102.levelOrder(t1);
    }
}
