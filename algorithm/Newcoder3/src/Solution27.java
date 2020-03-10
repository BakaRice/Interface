import java.util.ArrayList;

public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        char a[] = str.toCharArray();
        arrange(a, 0, a.length - 1, list);
        list.sort(null);
        return list;
    }

    /**
     * 递归全排列组合
     *
     * @param a
     * @param start
     * @param end
     * @param list
     */
    private void arrange(char[] a, int start, int end, ArrayList<String> list) {
        if (start == end) {
            String team = getstr(a);
            if (!list.contains(team))
                list.add(getstr(a));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(i, start, a);
            arrange(a, start + 1, end, list);
            swap(i, start, a);
        }
    }

    private String getstr(char[] a) {
        String str = "";
        for (int i = 0; i < a.length; i++)
            str += a[i];
        return str;
    }

    private void swap(int i, int j, char a[]) {
        char team = a[i];
        a[i] = a[j];
        a[j] = team;
    }
}