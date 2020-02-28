import java.util.ArrayDeque;
import java.util.Queue;

public class Solution17 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        if (root2 == null || root1 == null)
            return false;
        else {
            q1.add(root1);
            while (!q1.isEmpty()) {
                TreeNode t1 = q1.poll();
                if (jud(t1, root2))
                    return true;
                else {
                    if (t1.left != null) q1.add(t1.left);
                    if (t1.right != null) q1.add(t1.right);
                }
            }
            return false;
        }


    }

    public boolean jud(TreeNode r1, TreeNode r2) {//判断两二叉树是否相等
        if (r2 == null)
            return true;
        if (r1 == null)
            return false;
        else if (r1.val == r2.val) {
            return (jud(r1.left, r2.left) && jud(r1.right, r2.right));
        } else
            return false;
    }
}
