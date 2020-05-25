package Leetcode;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
 */

/*
因此，在旋转排序数组中查找一个特定元素时：

若 target == nums[mid]，直接返回
若 nums[left] <= nums[mid]，说明左侧区间 [left,mid]「连续递增」。
   ->此时：
    若 nums[left] <= target <= nums[mid]，说明 target 位于左侧。令 right = mid-1，在左侧区间查找
    否则，令 left = mid+1，在右侧区间查找
否则，说明右侧区间 [mid,right]「连续递增」。
   ->此时：
    若 nums[mid] <= target <= nums[right]，说明 target 位于右侧区间。令 left = mid+1，在右侧区间查找
    否则，令 right = mid-1，在左侧区间查找
注意：区间收缩时不包含 mid，也就是说，实际收缩后的区间是 [left,mid) 或者 (mid,right]

 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //如果数组 [left,mid] 连续递增
            if (nums[0] <= nums[mid]) {

                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;// 在左侧 [left,mid) 查找
                } else {
                    left = mid + 1;
                }
            } else {
                //如果数组 [mid,right] 连续递增
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1; // 在右侧 (mid,right] 查找
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //有序数组的二分查找
    int binarySearch(int[] nums, int target) {
        int NOT_FOUND = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else return mid;
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        leetCode33.binarySearch(a, 0);
    }
}
