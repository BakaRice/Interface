package Learn.sort;

public class QuickSort {

    private void quicksort(int[] a, int left, int right) {
            int low=left;
            int high=right;
            //下面两句的顺序一定不能混，否则会产生数组越界！！！very important！！！
            if(low>high)//作为判断是否截止条件
                return;
            int k=a[low];//额外空间k，取最左侧的一个作为衡量，最后要求左侧都比它小，右侧都比它大。
            while(low<high)//这一轮要求把左侧小于a[low],右侧大于a[low]。
            {
                while(low<high&&a[high]>=k)//右侧找到第一个小于k的停止
                {
                    high--;
                }
                //这样就找到第一个比它小的了
                a[low]=a[high];//放到low位置
                while(low<high&&a[low]<=k)//在low往右找到第一个大于k的，放到右侧a[high]位置
                {
                    low++;
                }
                a[high]=a[low];
            }
            a[low]=k;//赋值然后左右递归分治求之
            quicksort(a, left, low-1);
            quicksort(a, low+1, right);
        }

    public static void main(String[] args) {
        QuickSort Sort = new QuickSort();
        int a[] = {2, 8, 9, 3, 7, 6, 12, 4};
        Sort.quicksort(a, 0, a.length - 1);
        System.out.println(a);
    }
}
