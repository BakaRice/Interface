import java.util.Stack;

public class Solution20 {
    private int a[] = new int[1000];
    private int index = 0;
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        if (node < min)
            min = node;
        a[index] = node;
        index++;

    }

    public void pop() {
        if (a[--index] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
            }
        }
    }

    public int top() {
        return a[index - 1];
    }

    public int min() {
        return min;
    }
}
