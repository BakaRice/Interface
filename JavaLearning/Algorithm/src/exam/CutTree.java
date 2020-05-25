package exam;

import java.util.Scanner;

public class CutTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //用来表示一百颗树
        int tree[] = new int[101];
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            //用 1 表示此处的树存在
            tree[temp] = 1;
        }
        //首先计算街道的一侧
        int max = 0, len = 0, start = -1, truestart = 0;
        int street1[] = new int[50];
        for (int i = 1; i <= 100; i = i + 2) {
            if (tree[i] == 0 && start == -1) {
                start = i;
            }
            if (tree[i] == 1) {
                if (max < len) {
                    max = len;
                    truestart = start;
                }
                start = -1;
                len = 0;
                continue;
            }
            len++;
        }
        if (len > max) {
            truestart = start;
            max = len;
        }
        //计算街道的另一侧
        int max1 = 0, len1 = 0, start1 = -1, truestart1 = 0;
        for (int i = 2; i <= 100; i = i + 2) {
            if (tree[i] == 0 && start1 == -1) {
                start1 = i;
            }
            if (tree[i] == 1) {
                if (max1 < len1) {
                    max1 = len1;
                    truestart1 = start1;
                }
                start1 = -1;
                len1 = 0;
                continue;
            }
            len1++;
        }
        if (len1 > max) {
            truestart1 = start1;
            max1 = len1;
        }
        if (max > max1) {
            System.out.println(truestart + " " + max);
        } else {
            System.out.println(truestart1 + " " + max1);
        }
    }


    /*
    Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //用来表示一百颗树
        int tree[] = new int[101];
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            //用 1 表示此处的树存在
            tree[temp] = 1;
        }
        //首先计算街道的一侧
        int max = 0, len = 0, start = -1, truestart = 0;
        int street1[] = new int[50];
        for (int i = 1; i <= 100; i = i + 2) {
            if (tree[i] == 0 && start == -1) {
                start = i;
            }
            if (tree[i] == 1) {
                if (max < len) {
                    max = len;
                    truestart = start;
                }
                start = -1;
                len = 0;
                continue;
            }
            len++;
        }
        if (len > max) {
            truestart = start;
            max = len;
        }
        //计算街道的另一侧
        int max1 = 0, len1 = 0, start1 = -1, truestart1 = 0;
        for (int i = 2; i <= 100; i = i + 2) {
            if (tree[i] == 0 && start1 == -1) {
                start1 = i;
            }
            if (tree[i] == 1) {
                if (max1 < len1) {
                    max1 = len1;
                    truestart1 = start1;
                }
                start1 = -1;
                len1 = 0;
                continue;
            }
            len1++;
        }
        if (len1 > max) {
            truestart1 = start1;
            max1 = len1;
        }
        if (max > max1) {
            System.out.println(truestart + " " + max);
        } else
            System.out.println(truestart1 + " " + max1);
     */
}
