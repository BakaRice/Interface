package nowcoder;

/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution37 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return BF(root) != -1;
    }

    //递归写法
    public int BF(TreeNode node) {
        if (node == null) return 0;
        int l = BF(node.left);
        if (l == -1) return -1;
        int r = BF(node.right);
        if (r == -1) return -1;
        if (l - r > 1 || r - l > 1)
            return -1;
        else
            return 1 + (Math.max(l, r));
    }

}
