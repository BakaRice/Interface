package Leetcode.Exercise.array;

/**
 * @author RiceFamily
 * @date 2020/5/31 9:26
 */
public class T3 {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return;
        int count = 0;
        k = k % nums.length;
        for (int start = 0; count < nums.length; start++) {
            int curr = start;
            int prev = nums[start];
            do {
                int next = (curr + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curr = next;
                count++;
            }
            while (start != curr);
        }
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.rotate3(new int[]{-1, -100, 3, 99}, 2);
//        [-1,-100,3,99]
//        2
    }
}
