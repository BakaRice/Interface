package nowcoder;

public class Solution35 {
    public int GetNumberOfK(int[] array, int k) {
        int r = array.length;
        int l = 0;
        int mid = (r + l) / 2;
        int flag = 0;
        while (l < r) {
            if (array[mid] == k) {
                return search(array,mid);
            }
            if (k > array[mid]) l = mid+1;
            if (k < array[mid]) r = mid-1;
            mid = (r + l) / 2;
        }
        return 0;
    }
    private int search(int[] array, int mid) {
        int l=mid-1,r=mid+1;
        int value=0;
        while (l>=0&&array[l]==array[mid]) {
            value++;l--;
        }
        while (r<array.length&&array[r]==array[mid]) {
            value++;r++;
        }
        return value+1;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int a[] ={3,3,3,3,4,5};
        solution35.GetNumberOfK(a,3);
    }
}
