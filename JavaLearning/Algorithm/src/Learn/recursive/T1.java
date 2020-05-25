package Learn.recursive;

public class T1 {

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    void helper(char[] s, int start, int end) {
        char temp;
        if (start >= end) return;
        else {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
        helper(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        char[] c = {'H', 'O', 'L', 'A'};
        t1.reverseString(c);
    }

}
