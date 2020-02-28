public class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return jud(sequence, 0, sequence.length - 1);
    }

    public boolean jud(int a[], int left, int right)//左右包含左和右
    {
        int index = 0;
        int mid = 0;
        if (left >= right) return true;
        for (; index < right; index++) {
            if (a[index] > a[right])
                break;
        }
        mid = index;
        for (; index < right; index++) {
            if (a[index] < a[right]) break;
        }
        if (index != right) return false;
        else {
            return jud(a, left, mid - 1) && jud(a, mid, right - 1);
        }
    }
}
