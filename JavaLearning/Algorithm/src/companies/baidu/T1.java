package companies.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T1 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        //将sb装换成模式匹配
        for(int i=0; i<B.length(); i++)
            if(B.charAt(i) == '?')
                sb.append("[01]{1}");
            else
                sb.append(B.charAt(i));
        Set<String> res = new HashSet<>();

        for(int i=0; i<=A.length()-B.length(); i++){
            String sub = A.substring(i, i+B.length());
            if(sub.matches(sb.toString()))
                res.add(sub);
        }
        System.out.println(res.size());
    }
}
