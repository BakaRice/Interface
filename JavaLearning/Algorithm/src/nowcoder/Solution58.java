package nowcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution58 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //注意考试时的一些特殊情况的判断，如 为空 等等
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        queue1.offer(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode poll;
            if (!queue1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    poll = queue1.poll();
                    if (poll.left != null) queue2.offer(poll.left);
                    if (poll.right != null) queue2.offer(poll.right);
                    list.add(poll.val);
                }
                lists.add(list);
            }
            if (!queue2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    poll = queue2.poll();
                    if (poll.left != null) queue1.offer(poll.left);
                    if (poll.right != null) queue1.offer(poll.right);
                    list.add(poll.val);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
