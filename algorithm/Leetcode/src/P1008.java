public class P1008 {
    /**
     * 将1,2, \cdots ,91,2,⋯,9共99个数分成33组，
     * 分别组成33个三位数，且使这33个三位数构成1:2:3的比例，
     * 试求出所有满足条件的3个三位数。
     *
     * @param args
     */
    public static void main(String[] args) {
        int a, b, c, d, e, f, g, h, j;
        int num[] = new int[9];
        for (a = 1; a <= 3; a++)//第一个数百位不可能超过四
            for (b = 1; b <= 9; b++)
                for (c = 1; c <= 9; c++) {
                    int first = a * 100 + b * 10 + c;
                    num[0] = a;
                    num[1] = b;
                    num[2] = c;

                    int second = first * 2;
                    d = second / 100;
                    num[3] = d;
                    e = (second % 100) / 10;
                    num[4] = e;
                    f = second % 10;
                    num[5] = f;

                    int third = first * 3;
                    g = third / 100;
                    num[6] = g;
                    h = (third % 100) / 10;
                    num[7] = h;
                    j = third % 10;
                    num[8] = j;

                    int flag = 0;
                    for (int i = 0; i < 9; i++)
                        for (int p = i+1; p < 9; p++) {
                            if (num[i] == num[p]) {
                                flag = 1;
                            }
                        }
                    if (flag!=1&&third<999&&b!=0&&e!=0&&h!=0)
                        System.out.println(first+" "+second+" "+third);
                }

    }
}
