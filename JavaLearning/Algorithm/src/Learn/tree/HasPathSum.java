package Learn.tree;

public class HasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        dfs(root, 0, sum);
        return ans;
    }

    private void dfs(TreeNode root, int curr, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (curr + root.val == sum) {
                ans = true;
            }
        }
        if (root.left != null) {
            dfs(root.left, curr + root.val, sum);
        }
        if (root.right != null) {
            dfs(root.right, curr + root.val, sum);
        }
    }
}
