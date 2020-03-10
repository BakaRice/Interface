package Lanqiao;

import java.util.Scanner;

public class BASIC_14 {
   public static void main(String args[]){
       Scanner cin = new Scanner(System.in);
        int  t = cin.nextInt();
        int time = t/3600;
        int mins = t/60%60;
        int second = t-mins*60-time*3600;
        System.out.print(time+":"+mins+":"+second);
          }
}
