package nowcoder;


import java.util.LinkedList;
import java.util.Queue;

public class Solution56 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //非递归实现
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(pRoot);
        queue2.offer(pRoot);
        while (!queue.isEmpty() && !queue2.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode poll2 = queue2.poll();
            if (poll.val != poll2.val) return false;
            if (!(poll.left == null) ^ (poll2.right == null) && !(poll.right == null) ^ (poll2.left == null))//左右子树结构相同
            {
                if (poll.left != null) {
                    queue.add(poll.left);
                    queue2.add(poll2.right);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    queue2.add(poll2.left);
                }
            } else {
                return false;
            }
        }
        return true;
    }


    //递归实现
    public boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    public boolean isSymmetrical2(TreeNode pRoot) {
        return pRoot == null || jude(pRoot.left, pRoot.right);
    }
}
