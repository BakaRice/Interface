package Leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
全排列 回溯的想法 本质是一个n叉树
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class LeetCode46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute1(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack1(nums, track);
        return res;
    }

    void backtrack1(int[] nums, List<Integer> track) {
        //递归结束条件判断
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法选择
            if (track.contains(nums[i]))
                continue;
            //加入路径
            track.add(nums[i]);
            //递归进入下一层进行决策
            backtrack1(nums, track);
            //完成本层递归后 删除本层所做出的的选择
            track.remove(track.size() - 1);
        }
    }


    //梅开二度 第二次练习这道题 顺便要记得计算一下时间和空间复杂度


    List<List<Integer>> fullArrangement;

    public List<List<Integer>> permute(int[] nums) {
        fullArrangement = new ArrayList<>();
        if (nums.length == 0 || nums == null) return fullArrangement;
        List<Integer> tempList = new ArrayList<>();
        backtrack(nums, tempList);
        return fullArrangement;
    }

    private void backtrack(int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            fullArrangement.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法性
            boolean isExist = false;
            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j) == nums[i]) isExist = true;
            }
            if (isExist) continue;
            //添加入list
            tempList.add(nums[i]);
            //进入递归栈
            backtrack(nums, tempList);
            //退出队列 删除元素
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        leetCode46.permute(new int[]{1, 2, 3});
    }
}
