import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return lists;
        dfs(root, list, lists, target);
        return lists;
    }

    static Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            return list1.size() - list2.size();
        }
    };

    public void dfs(TreeNode node, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists, int target) {

        target = target - node.val;
        list.add((Integer) node.val);

        if (node.left != null) dfs(node.left, list, lists, target);
        if (node.right != null) dfs(node.right, list, lists, target);

        if (node.right == null && node.left == null && target == 0) {
            ArrayList<Integer> list1 = new ArrayList<>();
            //list.add(node.val);
            list1.addAll(list);
            //list.remove(list.size()-1);
            lists.add(list1);
        }
        target = target + node.val;
        list.remove(list.size() - 1);


    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(solution24.FindPath(t1, 22));
    }
}