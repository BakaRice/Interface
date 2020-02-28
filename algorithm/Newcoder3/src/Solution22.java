import java.time.temporal.Temporal;
import java.util.ArrayList;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<TreeNode> Nodelist = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Nodelist.add(root);
        while (!Nodelist.isEmpty()) {
            TreeNode temp = Nodelist.get(0);
            if (temp.left != null) Nodelist.add(temp.left);
            if (temp.right != null) Nodelist.add(Nodelist.get(0).right);
            //System.out.println(Nodelist.get(0).val);
            list.add(Nodelist.get(0).val);
            Nodelist.remove(0);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = null;
        t1.left = t2;
        t1.right = t3;
        System.out.println(solution22.PrintFromTopToBottom(t4));
    }
}