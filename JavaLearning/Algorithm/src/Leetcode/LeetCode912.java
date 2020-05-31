package Leetcode;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 给你一个整数数组 nums，将该数组升序排列。
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;

    }

    public int[] sortArray1(int[] nums) {
        long s = System.currentTimeMillis();
        System.out.println(s);
        quickSort(nums,0, nums.length - 1);
        long e = System.currentTimeMillis();
        System.out.println(e);
        System.out.println("time="+(e-s));
        return nums;
    }

     void quickSort(int[] array,int low,int high){
        if(low>=high){
            return;
        }
        int index = random_divide(array,low,high);
        quickSort(array,low,index-1);
        quickSort(array,index+1,high);
    }

    int random_divide(int [] nums, int l, int r) {
        int i = (int) (Math.random()*(r - l + 1) + l); // 随机选一个作为我们的主元
        int k = nums[l];
        nums[l] = nums[i];
        nums[i] = k;
        return divide(nums, l, r);
    }

    int divide(int[] array,int low,int high){
        int i = low+1, j = high;
        while(i<=j){
            while(i<=j&&array[i]<=array[low]){
                i++;
            }
            while(i<=j&&array[j]>array[low]){
                j--;
            }
            if(i<=j) {
                int k = array[j];
                array[j] = array[i];
                array[i] = k;
            }
        }
        int t = array[low];
        array[low] = array[j];
        array[j] = t;
        return j;
    }

    public static void main(String[] args) {
        LeetCode912 leetCode912 = new LeetCode912();
        int nums[] = {5,1,1,2,0,0};
        leetCode912.sortArray1(nums);
    }
}
