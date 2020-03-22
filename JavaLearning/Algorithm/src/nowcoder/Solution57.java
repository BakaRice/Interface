package nowcoder;


import java.util.ArrayList;
import java.util.Stack;

public class Solution57 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> queue = new Stack<>();
        Stack<TreeNode> queue2 = new Stack<>();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            TreeNode tempNode;
            if (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
//                queue2.clear();
                while (!queue.isEmpty()) {
                    tempNode = queue.pop();
                    if (tempNode.left != null) queue2.push(tempNode.left);
                    if (tempNode.right != null) queue2.push(tempNode.right);

                    list.add(tempNode.val);
                }
                lists.add(list);
            }
            if (!queue2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
//                queue.clear();
                while (!queue2.isEmpty()) {
                    tempNode = queue2.pop();
                    if (tempNode.right != null) queue.push(tempNode.right);
                    if (tempNode.left != null) queue.push(tempNode.left);

                    list.add(tempNode.val);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
