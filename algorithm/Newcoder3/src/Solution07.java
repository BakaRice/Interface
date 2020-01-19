public class Solution07 {
    public int Fibonacci(int n) {
        if (n==0) return 0;
        if(n==1) return 1;
        else if(n==2) return 1;
        else return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        System.out.print(solution07.Fibonacci(39));
    }
}