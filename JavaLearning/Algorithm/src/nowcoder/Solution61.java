package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution61 {
    LinkedList<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        int l=0,r=list.size()-1;
        int mid=(l+r)/2;
        while (l<r) {
            if(list.get(mid)<num)
            {
                l=mid+1;
                mid=(l+r)/2;
            }
            else if (list.get(mid)>num) {
                r=mid;
                mid=(l+r)/2;
            }
            else {
                l=r=mid;
            }
        }
        list.add(l, num);
    }

    public Double GetMedian() {
        if(list.size()%2==1)
        {
            return (double)list.get(list.size()/2);
        }
        else {
            return ((double) (list.get((list.size())/2-1)+list.get(list.size()/2))/2);
        }
    }


}
