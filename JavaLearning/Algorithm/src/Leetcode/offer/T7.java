package Leetcode.offer;

import java.util.Arrays;

/**
 * @author RiceFamily
 * @date 2020/5/31 14:28
 */
public class T7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;
    }
}
