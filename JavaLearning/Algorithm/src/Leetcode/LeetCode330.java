package Leetcode;
/*
 作者：LeetCode
        链接：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }
}
