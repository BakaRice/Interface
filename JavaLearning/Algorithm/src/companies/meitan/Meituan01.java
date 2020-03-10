package companies.meitan;

import java.util.Scanner;

public class Meituan01 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int depth[] = new int[n + 1];
//        for (int i = 0; i < n-1; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            depth[b] = depth[a] + 1;
//        }
//        int maxDepth = 0;
//        for (int i = 1; i <= n; i++) {
//            if (depth[i] > maxDepth)
//                maxDepth = depth[i];
//        }
//        System.out.println(2*n-2*maxDepth);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n个点
        int[] depth = new int[n+1];
        for(int i=0;i<n-1;i++){
            //节点从1到n，n-1个节点
            int a = sc.nextInt();
            int b = sc.nextInt();
            depth[b] = depth[a]+1;
        }
        int maxDepth = 0;
        for(int i=1;i<=n;i++){
            if(depth[i]>maxDepth){
                maxDepth = depth[i];
            }
        }
        System.out.println(2*n-2-maxDepth);
    }

}
