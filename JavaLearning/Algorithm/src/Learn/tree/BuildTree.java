package Learn.tree;

import java.util.HashMap;
import java.util.Map;

//从中序与后序遍历序列构造二叉树
//https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo98qt/
public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int n = postorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] postorder, int[] inorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int pivot = indexMap.get(postorder[postRight]);
        TreeNode root = new TreeNode(inorder[pivot]);

        root.left = myBuildTree(postorder, inorder, postLeft, postRight - inRight + pivot - 1, inLeft, pivot - 1);
        root.right = myBuildTree(postorder, inorder, postRight - inRight + pivot, postRight - 1, pivot + 1, inRight);

        return root;
    }
}
