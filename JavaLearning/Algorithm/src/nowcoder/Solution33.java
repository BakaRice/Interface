package nowcoder;

public class Solution33 {

    /*
    题目描述
    在数组中的两个数字，如果前面一个数字大于后面的数字，
    则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
    并将P对1000000007取模的结果输出。 即输出P%1000000007

    分治法：递归到最小 每一个单独的视为有序的。
     */
    static  int value =0;
    public int InversePairs(int [] array) {
            mergesort(array,0,array.length-1);
            return value;
    }

    void mergesort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergesort(array, left, mid);
            mergesort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int lindex = left;
        int rindex = mid + 1;
        int team[] = new int[right - left + 1];
        int teamindex = 0;
        while (lindex <= mid && rindex <= right) {
            if (array[lindex] <= array[rindex]) {
                team[teamindex] = array[lindex];
                teamindex++;
                lindex++;
            } else {
                team[teamindex] = array[rindex];
                value+=mid-lindex+1;
                value%=1000000007;
                teamindex++;
                rindex++;
            }
        }
        while (lindex <= mid) {
            team[teamindex++] = array[lindex++];
        }
        while (rindex <= right) {
            team[teamindex++] = array[rindex++];
        }
        for (int i = 0; i < teamindex; i++) {
            array[left + i] = team[i];
        }
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int array[] = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        solution33.InversePairs(array);
    }
}
