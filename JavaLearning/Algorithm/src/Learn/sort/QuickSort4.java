package Learn.sort;

import java.util.Arrays;

/**
 * 单边交换法的快速排序
 */
public class QuickSort4 {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);

        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 单边循环法 分治
     * @param arr 待交换的数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
