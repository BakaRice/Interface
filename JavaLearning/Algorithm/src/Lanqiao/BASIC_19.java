package Lanqiao;

import java.util.Scanner;

public class BASIC_19 {
//a b b c  h c a
    // a b c h c b a
    //如果存在两个以上的奇数次字符则不可能为回文字
public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
//    int n = Integer.parseInt(scanner.nextLine());
//   String str = scanner.nextLine();
//   char[] chs = str.toCharArray();
//    String str = "rzxezex";
//    int  n =str.length();
//    char[] chs = str.toCharArray();
//    int[] count = new int[26];
//    char ch = '0';
//    int oddchar = 0;
//
//    for (int j = 0; j < chs.length; j++) {
//        int index = chs[j] - 'a';
//        count[index]++;
//    }
//
//    for (int i = 0; i < 26; i++) {
//        if (count[i] % 2 != 0) {
//            oddchar++;
//            ch = (char) (i + 'a');
//        }
//    }
//
//    if (oddchar > 1) {
//        System.out.println("Impossible");
//    } else {
//        int exctime = 0;
//       //如果没有超过两个以上的奇数次出现
//        for(int i = 0 ;i < chs.length; i++){
//            if (chs[i]!=chs[chs.length-1-i])//如果首部和对应尾部不同
//                if (chs[i]==ch)
//            for (int j =chs.length-1-i;j>0;j--){
//                if (chs[i]==chs[j]){
//                    for (int p = j;p<chs.length-1-i;p++){
//                        char temp = chs[p];
//                        chs[p] = chs[p+1];
//                        chs[p+1] = temp;
//                        exctime++;
//                    }
//                    break;//找到并移位后即可停止循环
//                }
//            }
//        }
//        System.out.println(exctime);
//        System.out.println(chs);
//    }
//}
//    private static int exchange(char[] chs, int n, char ch) {
//        int count = 0, i, j, k;
//        for (i = 0; i < n / 2; i++) {
//            if (chs[i] == ch) {
//                for (j = i; j < n - i - 1; j++) {
//                    if (chs[j] == chs[n - i - 1]) {
//                        break;
//                    }
//                }
//
//                count += j - i;
//
//                for (k = j; k > i; k--) {
//                    chs[k] = chs[k - 1];
//                }
//                chs[i] = chs[n - i - 1];
//
//            } else {
//                for (j = n - i - 1; j >= i; j--) {
//                    if (chs[j] == chs[i]) {
//                        break;
//                    }
//                }
//
//                count += n - i - 1 - j;
//
//                for (k = j; k < n - i - 1; k++) {
//                    chs[k] = chs[k + 1];
//                }
//                chs[n - i - 1] = chs[i];
//            }
//        }
//        return count;
//    }//
      Scanner scanner = new Scanner(System.in);
      int n = Integer.parseInt(scanner.nextLine());
      String str = scanner.nextLine();
       char[] s = str.toCharArray();
        int j = n - 1;
        int cnt = 0;//cnt用来统计交换的次数
        int flag = 0;//flag判断是否已经有一个单独的奇个数的字符了
        for(int i = 0; i < j; i++)  //i指针从头遍历到倒数第二个字符
        {
            for(int k = j; k >= i; k--)  //k指针从后面往前一直到i寻找和s[i]相同的s[k]
            {
                if(k == i)  //如果找不到相同的，允许存在一次找不到的情况 如果有两次就炸啦
                {
                    if(n % 2 == 0 || flag == 1)  //impossible的两种情况
                    {//如果找不到相同的 还是偶数个数字 肯定就 成不了回文字
                        //如果找不到相同的 但是奇数次 可以为中间数字
                        System.out.println("Impossible");
                        return;
                    }
                    flag = 1;
                    cnt += n / 2 - i;//视为将其移动到中央所需的次数
                    /*
                    存在一个问题 如果存在只有一个的奇数字母 他将不能被移动，
                    因为多个奇数的情况下 其余的一个奇数会被迫的前往最中央的位置的
                     */
                }
                else if(s[k] == s[i])
                {
                    for(int l = k; l < j; l++)
                    {   char temp = s[l];
                        s[l] = s[l+1];
                        s[l+1] =  temp;
                        //swap(s[l], s[l+1]);//把s[k]换到s[j]处
                        cnt++;//统计交换次数
                    }
                    j--;
                    break;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(s);

    }
}
