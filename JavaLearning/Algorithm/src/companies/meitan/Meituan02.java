package companies.meitan;

import java.util.Scanner;

public class Meituan02 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String first[] = br.readLine().trim().split(" ");
//        int n = Integer.parseInt(first[0]);
//        int k = Integer.parseInt(first[1]);
//        String[] arr = br.readLine().split(" ");
//        int line[] = new int[n];
//        int sum_0 = 0;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            line[i] = Integer.parseInt(arr[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            if (line[i] == 0) sum_0++;
//            if (sum_0 > k) {
//                int temp = 0;
//                int temp2 = 0;
//                for (int j = 0; ; j++) {//正向
//                    if (temp == k && line[j] == 0) {
//                        if (max < j - 1) max = j;
//                        break;
//                    }
//                    if (line[j] == 0) temp++;
//                }
//                for (int j = i; ; j--) {
//                    if (temp2 == k && line[j] == 0) {
//                        if (max < i - j) max = i - j;
//                        break;
//                    }
//                    if (line[j] == 0) temp2++;
//                }
//            } else max = i + 1;
//        }
//        System.out.println(max);
//    }
//

    //双指针移动 分为左右 进行移动
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int left = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {//遇到0时 则k-1

                while (K == 0) {//k=0时开始移动左指针
                    if (nums[left] == 0) {
                        K++;
                    }
                    left++;
                }
                K--;
            }
            max = Math.max(i - left + 1, max);
        }
        System.out.println(max);
    }
}
