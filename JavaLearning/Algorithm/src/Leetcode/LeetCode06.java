package Leetcode;

public class LeetCode06 {
        public String convert(String s, int numRows) {
//            int n = s.length();String newstr = new String();
//            int p =0;
//            for (int i =0;i<n;i = p*(numRows-1)){
//                System.out.print(s.charAt(i));
//                newstr.concat( Character.toString(s.charAt(i)));
//                p=p+2;
//            }//第一行输出

            //以整体的角度考虑输出的问题
            int p = 0;String newstr = new String();
            if (numRows==1)
                return newstr+s;
            for(int col = 0;col <= numRows-1;col++){
                p=0;
                for (int i = 0;i < s.length() ;i = p*(numRows-1)){
                    if (i+col-1<=s.length())//判定是否超过长度，超过不记
                        if (col==numRows-1||col==0){//if the first or end colums
                            if (i+col<s.length())//最后一个元素是否存在
                            newstr = newstr+s.charAt(i+col);
                        }else{
                            if (i+col<=s.length()-1)
                           newstr = newstr+s.charAt(i+col);
                           //下个元素如果存在
                           if(i+col+2*(numRows-1-col)<=s.length()-1){
                               newstr = newstr+s.charAt(i+col+2*(numRows-1-col));
                           }
                        }
                    p = p+2;
                }
            }
            return newstr;
        }

    public static void main(String[] args) {
        LeetCode06 leetCode06 = new LeetCode06();
        String n = leetCode06.convert("PAYPALISHIRING", 4);
        //"PAYPALISHIRING"
        //4
        //"PAYPALISHIRING"
        //3
        //"PINALSIGYAHRPI"
        System.out.print("\n"+n);
    }
}
