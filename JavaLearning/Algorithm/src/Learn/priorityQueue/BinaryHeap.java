package Learn.priorityQueue;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/11 17:09
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private AnyType[] array;

    public void insert(AnyType x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = x;
    }

    public void enlargeArray(int newSize) {

    }
}
