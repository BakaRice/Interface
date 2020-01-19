public class LeetCode04{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

           /*
              left_part          |        right_part
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

            在统计中，中位数被用来：
            将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
            在上述方法计算中 必须要求n>=m 否则 j将会为负数
            如果n,m不满足上述条件 要将其对调

            */
            int m = nums1.length;
            int n = nums2.length;
            if (m>n){//to ensure m<=n;
                int []temp = nums1;nums1= nums2;nums2= temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0,iMax= m, halfLen = (m+n+1)/2;
            while(iMin < iMax){
                int i = (iMax+iMin)/2;
                int j = halfLen-i;
                if(i<iMax && nums2[j-1]>nums1[i]){
                    iMin = i+1;// i  is to samll
                }else if(i>iMin && nums1[i-1]>nums2[j]){
                    iMax = i -1;//i  is to big;
                }
                else { // i  is perfect
                   int maxLeft = 0;
                   if (i == 0){maxLeft = nums2[j-1];}
                   else  if (j==0 ){maxLeft = nums1[i-1];}
                   else {maxLeft=Math.max(nums1[i-1],nums2[j-1]);}
                   if ((m+n)%2==1) {return maxLeft;}

                   int minRight = 0;
                   if(i == m){minRight = nums2[j];}
                   else if(j==n){minRight=nums1[i];}
                   else {minRight = Math.min(nums2[j],nums1[i]);}

                   return (maxLeft+minRight)/2.0;
                }
            }
            return 0.0;
        }

         public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

//视为求最小第k个数字的位置=》如此等效看
    public double findMedianSortedArraysk(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        LeetCode04 leetCode04 = new LeetCode04();
        int [] A = {1,2};
        int [] B = {3};
        System.out.println(leetCode04.findMedianSortedArrays(A, B));
        }
}

