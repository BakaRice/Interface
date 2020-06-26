package Learn.sort;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/11 11:00
 * 插入排序由N-1趟排序组成，对于p=1 到  N-1 趟，插入排序保证从位置0到位置p上的元素为已排序状态。
 */
public class InsertionSort {
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            //位置p上的元素存储在tmp，而（位置在p之前）所有更大的元素都被向右移动了一个位置，然后tmp被放到正确的位置。
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{8, 34, 64, 51, 32, 21};
        insertionSort(array);
    }

}
