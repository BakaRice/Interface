package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) return lists;
        int a = 0;
        int b = a + 1;
        int c = b + 1;
        int d = nums.length - 1;
        int sum = nums[a] + nums[b] + nums[c] + nums[d];
//        while (a < d) {
//            if (a > 0 && nums[a] == nums[a - 1]) {
//                a++;
//                continue;
//            }
//            b = a + 1;
//            while (b < d) {
//                if (b > a + 1 && nums[b] == nums[b - 1]) {
//                    b++;
//                    continue;
//                }
//                c = b + 1;
//                d = nums.length - 1;
//                while (c < d) {
//                    sum = nums[a] + nums[b] + nums[c] + nums[d];
//                    if (sum > target)
//                        d--;
//                    else if (sum < target)
//                        c++;
//                    else if (sum == target) {
//                        ArrayList<Integer> l = new ArrayList<>();
//                        l.add(nums[a]);
//                        l.add(nums[b]);
//                        l.add(nums[c]);
//                        l.add(nums[d]);
//                        lists.add(l);
//                        while (c < d && nums[c + 1] == nums[c])      //确保nums[c] 改变了
//                            c++;
//                        while (c < d && nums[d - 1] == nums[d])      //确保nums[d] 改变了
//                            d--;
//                        c++;
//                        d--;
//                    }
//                }
//                b++;
//            }
//            a++;
//        }
        int len = nums.length;
        for (a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;//最小值都大于terget
            for (b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                c = b + 1;
                d = len - 1;
                int min = nums[a] + nums[b] + nums[c] + nums[c + 1];
                if (min > target) break;//最小值都大于terget
                int max = nums[a] + nums[b] + nums[d - 1] + nums[d];
                if (max < target) break;//最大值都小于terget
                while (c < d) {
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target)
                        d--;
                    else if (sum < target)
                        c++;
                    else if (sum == target) {
                        lists.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }


        return lists;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int h = length - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) {
                            h--;
                        }

                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        int[] nums = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums1 = new int[]{0, 0, 0, 0};
        int[] num2 = {1, 0, -1, 0, -2, 2};
        leetCode18.fourSum(num2, 0);
    }

}
