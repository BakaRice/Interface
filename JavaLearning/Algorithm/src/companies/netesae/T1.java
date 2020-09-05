package companies.netesae;

import java.util.Arrays;
import java.util.Scanner;

public class T1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            if(num==0){
                System.out.println(0);
            }else{
                for(int i=0;i<num;i++){
                    long num1=sc.nextLong();
                    long num2=sc.nextLong();
                    long num3=sc.nextLong();
                    long [] ar=new long[3];
                    ar[0]=num1;
                    ar[1]=num2;ar[2]=num3;
                    Arrays.sort(ar);
                    long mean=(num3+num1+num2)/3;
                    long sum=num3+num1+num2;
                    if(ar[0]+ar[1]<=mean){
                        long p=ar[2]/2+ ar[2]%2;
                        System.out.println(p);
                    }else{
                        long p=sum/3;
                        if(sum%3!=0){
                            p++;
                        }
                        System.out.println(p);
                    }
                }
            }
        }
    }
}