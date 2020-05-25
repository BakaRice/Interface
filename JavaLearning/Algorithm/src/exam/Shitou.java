package exam;

import java.util.Map;
import java.util.Scanner;

/*
沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。问最少需要操作多少次才能将这n个石头的半径变成升序？
 */
public class Shitou {
    public static void main(String[] args) {
        int n = 0, num = 0, anchor = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //定义一个数组 表示石头
        int rock1[] = new int[n];
        for (int i = 0; i < n; i++) {
            rock1[i] = scanner.nextInt();
            if (i > 0 && rock1[i - 1] > rock1[i]) anchor = i;
            num = Math.max(num, i - anchor + 1);
        }
//        for (int i = 0; i < n; i++) {
//
//        }
        System.out.println(n-num);


    /*
    int n=0,num = 1,maxline = 1;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //定义一个数组 表示石头
        int rock1[] = new int[n];
        for (int i = 0; i < n; i++) {
            rock1[i] = scanner.nextInt();
        }
        //定义另一个数组以判断是否是递增关系
        int rock2[] = new int[n];
        for (int i = 0; i < n; i++) {
            rock2[i] = rock1[i];
            for (int j = i + 1; j < n; j++) {
               rock2[j]= rock1[j];
                if (rock2[i] + 1 == rock1[j]) {
                    num++;
                    rock2[i] = rock1[j];
                }
            }
            if (num >= maxline) {
                maxline = num;
            }
            num =1;
        }
        System.out.println(n-maxline);
     */
    }
}
