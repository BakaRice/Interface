public class Solution08{

    public int JumpFloor(int target) {
        if(target == 0 ) return 0;
        if(target == 1 ) return 1;
        else if(target == 2) return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        System.out.print(solution08.JumpFloor(3));
    }
}