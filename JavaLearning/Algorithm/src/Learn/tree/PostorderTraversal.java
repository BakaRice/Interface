package Learn.tree;

import java.util.*;

public class PostorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //递归 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, ans);
            }
            if (root.right != null) {
                helper(root.right, ans);
            }
            ans.add(root.val);
        }
    }

    //非递归 后序遍历
    public List<Integer> postorderTraversal_2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.addLast(curr);
                mp.put(curr.val, 1);
                curr = curr.left;
            } else {
                curr = stack.peekLast();
                if (mp.get(curr.val) == 2) {
                    stack.pollLast();
                    ans.addLast(curr.val);
                    curr = null;
                } else {
                    mp.put(curr.val, 2);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    //非递归 后序遍历二叉树  将前序遍历倒置 对照前序代码
    public List<Integer> postorderTraversal_3(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            //这里的root是借用上面的结点地址，避免了新申请地址带来的时间消耗
            root = stack.pollLast();
            ans.addFirst(root.val);
            if (root.left != null) {
                stack.addLast(root.left);
            }
            if (root.right != null) {
                stack.addLast(root.right);
            }
        }
        return ans;
    }

}
/*
在前面的前序和中序先到最左侧压入栈的时候，两种顺序依次是

 前序: 中入栈——>左入栈——>左出栈——>中出栈——>右入栈——>右孩子入出——>右出栈 在入栈时候操作即可前序
 中序: 中入栈——>左入栈——>左出栈——>中出栈——>右入栈 ——>右孩子入出——>右出栈 按照出栈顺序即可完成中序

 */