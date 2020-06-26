package Learn.sort;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/11 12:25、
 * 希尔排序使用一个增量序列h1,h2,...,ht,使用增量hk的一趟排序后，对于每一个i我们都有a[i]<=a[i+hk]；
 */
public class ShellSort {

    public static <AnyType extends Comparable<? super AnyType>>
    void shellsort(AnyType[] a) {

        int j;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            //对于每一个元素都要进行相应的一轮hgap排序
            for (int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                //类似插入排序的过程 避免显式的使用交换 只是距离不再是 j 和j-1 而是对于hgap排序的j和j-gap
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        }
    }


}
