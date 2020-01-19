import java.util.Stack;

public class Solution3 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //{3,2,5,4,9}
    //empty queue
    // queue 3 2 5 7 9
    //stack1 3 2
    //stack2
    //
    public void push(int node) {
      stack1.push(node);//把数据放入栈1
    }
    // queue 3 2 5 7 9
    //stack1 2
    //stack2 2
    //
    public int pop() {
        while (stack2.empty())//如果栈2空了就再给他压进去一点
        {
            while (!stack1.empty())
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
//        while (!stack2.empty()) //这里不用再把栈2的内容给压回栈1 将栈1和2联合视为一个队列就可
//        {
//            stack1.push(stack2.pop());
//        }
        return temp;
    }



    public void push1(int node) {
        stack1.push(node);
    }

    public int pop1() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        s3.push(1);
        s3.push(2);
        s3.push(3);
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        s3.push(4);
        System.out.println(s3.pop());
        s3.push(5);
        System.out.println(s3.pop());
        System.out.println(s3.pop());
    }
}