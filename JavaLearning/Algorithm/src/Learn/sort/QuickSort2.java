package Learn.sort;

/**
 * @author RiceFamily
 * @date 2020/8/20 11:59
 */
public class QuickSort2 {
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mark = sort(array, left, right);
            quickSort(array, left, mark - 1);
            quickSort(array, mark + 1, right);
        }
    }

    private static int sort(int[] array, int left, int right) {
        int mark = array[left];
        while (left < right) {
            while (left < right && array[right] >= mark) right--;
            swap(array, left, right);
            while (left < right && array[left] <= mark) left++;
            swap(array, left, right);
        }
        return left;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
