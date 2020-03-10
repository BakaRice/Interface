import java.util.ArrayDeque;
import java.util.Queue;

public class Solution18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {
        if (root ==null) return;
        Queue<TreeNode> q1 = new ArrayDeque<>();
        TreeNode newTree = root;
        TreeNode tempTree;
        q1.add(root);
        while (!q1.isEmpty()) {
            TreeNode t1 = q1.poll();
            if (t1.left != null) q1.add(t1.left);
            if (t1.right != null) q1.add(t1.right);

            tempTree = t1.left;
            t1.left = t1.right;
            t1.right = tempTree;

        }
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        TreeNode treeNode =  new TreeNode(11);
        solution18.Mirror(null);
    }

}
