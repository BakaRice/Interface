import java.util.HashMap;
import java.util.Map;

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
