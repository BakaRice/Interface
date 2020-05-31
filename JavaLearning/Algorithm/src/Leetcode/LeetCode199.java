package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> EvenQue = new LinkedList<>();
        Queue<TreeNode> OddQue = new LinkedList<>();
        TreeNode temp = root;
        List<Integer> outList = new LinkedList<>();
        if (temp==null) return outList;
        EvenQue.add(temp);
        while (!EvenQue.isEmpty()||!OddQue.isEmpty()){
            while (!EvenQue.isEmpty()) {
                TreeNode poll = EvenQue.poll();
                if (poll.left != null) OddQue.add(poll.left);
                if (poll.right != null) OddQue.add(poll.right);
                if (EvenQue.isEmpty()) outList.add(poll.val);
            }
            while (!OddQue.isEmpty()) {
                TreeNode poll = OddQue.poll();
                if (poll.left != null) EvenQue.add(poll.left);
                if (poll.right != null) EvenQue.add(poll.right);
                if (OddQue.isEmpty()) outList.add(poll.val);
            }
        }

        return  outList;
    }
}
