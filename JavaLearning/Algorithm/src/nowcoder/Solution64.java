package nowcoder;

import java.util.Queue;

public class Solution64 {
    int X[] = {-1, 0, 1, 0};
    int Y[] = {0, 1, 0, -1};
    int num = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean jud[][] = new boolean[rows][cols];
        dfs(0, 0, rows, cols, threshold, jud);
        return num;
    }

    private void dfs(int x, int y, int rows, int cols, int threshold, boolean[][] jud) {
        int count=nadd(x,y);
        if(count>threshold) return;
        else {
            num++;
            jud[x][y]=true;
            for(int i=0;i<4;i++)
            {
                if(x+X[i]>=0&&x+X[i]<rows&&y+Y[i]>=0&&y+Y[i]<cols&&!jud[x+X[i]][y+Y[i]])//不越界
                {
                    dfs(x+X[i], y+Y[i], rows, cols, threshold, jud);
                }
            }
        }
    }


    //判断（rows,cols)是否可达
    private int nadd(int x, int y) {//计算个位数字之和
        int num = 0;
        while (x > 0) {
            num += x % 10;
            x /= 10;
        }
        while (y > 0) {
            num += y % 10;
            y /= 10;
        }
        return num;
    }
}
