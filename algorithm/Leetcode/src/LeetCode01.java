import java.util.HashMap;
import java.util.Map;
/*
#两个数字之和  
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。  
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。  
  
示例: 
给定 nums = [2, 7, 11, 15], target = 9  
因为 nums[0] + nums[1] = 2 + 7 = 9  
所以返回 [0, 1]  
*/
public class LeetCode01 {
    public int[] twoSum(int[] nums, int target) {
        //int[] temp = new int[2];//暴力搜索版本
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target)
        {
            return  new int[] {i,j};
//            temp[0]=i;
//            temp[1]=j;
//            return temp;
        }
        return null;
    }
    public int[] twoSum2(int[] nums,int target){
        //一次哈希map,存在一个问题就是不能有两个重复的数字 否则hashmap就炸啦
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
            map.put(nums[i],i);
        for(int i =0;i < nums.length;i++)
        {
           int complement = target - nums[i];
           if(map.containsValue(complement)&& map.get(complement)!=i){
               return  new int[] {i,map.get(complement)};
           }
        }throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetCode01 leetCode01 = new LeetCode01();
        int[] nums = {3,3};
        int[] out = leetCode01.twoSum2(nums, 6);
        System.out.print(out[0]);
        System.out.print(out[1]);
    }
}
