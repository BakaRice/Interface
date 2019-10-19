import java.lang.reflect.Array;

public class Test {
    public static boolean Find(int target, int [][] array) {
        int cols = array.length - 1;
        while(array[cols][0]>=target&&cols+1>0)
        {
            if(array[cols][0]==target)//如果第一个就是target输出
                return true;
            else if(cols==0)//如果直到array[0][0]仍没有找到则为false
                return false;
            else cols = cols-1;
        }
        for(int j=cols;j>0;j--) {
            for (int i = 0; i < array[0].length; i++) {
                if (array[j][i] == target)
                    return true;
            }
        }return false;
    }

    public String replaceSpace(StringBuffer str) {
        if(str ==null)
            return null;
        StringBuffer strnew = new StringBuffer();
        for(int i = 0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
                strnew.append("%20");
            }
            else
                strnew.append(str.charAt(i));
        }
        return strnew.toString();
    }

    public static boolean Find3(int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;
        while (col<=array[0].length-1&&row>=0){
            if (target==array[row][col])
                return true;
            else if(array[row][col]>target)//如果标记比当前数字小，则向上跳一行
                row--;
            else  col++;//如果标记数字比当前数字大，则向右跳一列
        }
        return false;
    }

    public static boolean Find2(int [][] array,int target) {
            int row=0;
            int col=array[0].length-1;
            while(row<=array.length-1&&col>=0){
                if(target==array[row][col])
                    return true;
                else if(target>array[row][col])
                    row++;
                else
                    col--;
            }
            return false;

        }

    public static void main(String[] args) {
        //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        //{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //1,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 7;
        for (int i =0;i<array.length;i++)
        {
            System.out.println();
            for(int j = 0;j<array[0].length;j++)
                System.out.print(array[i][j]);
        }
        System.out.println(Find3(1,array));
    }


}
