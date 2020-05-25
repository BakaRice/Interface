package exam.virtual;

public class T1 {
    int max;

    public int findLUSlength(String a, String b) {
        max = Integer.MIN_VALUE;
        if (a.length() == 0) return b.length();
        if (b.length() == 0) return a.length();
        if (a.equals(b)) return -1;
        subString(a, b);
        subString(b, a);
        return max;
    }


    private void subString(String a, String b) {
        if (a.length() == 0) return;
        if (!b.contains(a)) {
            if (a.length() > max)
                max = a.length();
        } else {
            subString(a.substring(1), b);
            subString(a.substring(0, a.length() - 1), b);
        }

    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.findLUSlength("aba", "cdc"));
    }
}
