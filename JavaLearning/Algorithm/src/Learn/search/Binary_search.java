package Learn.search;

/**
 * @author RiceFamily
 * @date 2020/8/20 11:57
 */
public class Binary_search {
    private static Boolean Binary_search(int[] array, int i) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        if (right < left || i < array[left] || i > array[right])
            return false;
        while (right >= left) {
            middle = right + (left - right) / 2;//可能溢出，超过int存储的字节
//            middle=left+(right-left)/2;
            if (array[middle] == i) {
                return true;
            } else if (array[middle] < i) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
