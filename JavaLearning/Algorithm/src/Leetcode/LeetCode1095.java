package Leetcode;


public class LeetCode1095 {
    // This is MountainArray's API interface.
    // You should not implement it, or speculate about its implementation
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int mountainTop = findMountainTop(mountainArr, 0, size - 1);
        int res = findFromSortedArr(mountainArr, 0, mountainTop, target);
        if (res != -1) return res;
        return findFromInversedArr(mountainArr, mountainTop + 1, size - 1, target);

    }

    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findFromInversedArr(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        //当数组长度收缩到为1时 判断是否为target
        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    private int findFromSortedArr(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }


}
