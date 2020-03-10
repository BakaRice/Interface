package companies.didi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
  在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 */
/*
将桌子大小由小到大排列，创建顾客类，将人数不大于最大桌子的顾客放入优先级队列中，顾客消费金额大的排在前面，flag数组
记录桌子是否已经有人坐了，sum统计最后的总消费金额，count记录桌子被使用的个数，遍历队列，依次取出顾客，并遍历桌子
数组，若此桌子可以坐下这批顾客并且桌子没有人坐，就坐下来，遍历队列过程中发现桌子已经用完了(count==n) ,直接跳出循环。
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] table = new int[n];
            for (int i = 0; i < table.length; i++) {
                table[i] = sc.nextInt();
            }
            Arrays.sort(table);
            PriorityQueue<Customer> queue = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (b <= table[n - 1]) {
                    queue.add(new Customer(b, c));
                }
            }
            long sum = 0;
            int count = 0;
            boolean[] flag = new boolean[n];
            while (!queue.isEmpty()) {
                Customer customer = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (table[j] >= customer.num && !flag[j]) {
                        sum += customer.fee;
                        count++;
                        flag[j] = true;
                        break;
                    }
                }
                if (count==n){
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}

class Customer implements Comparable<Customer> {

    public int num;
    public int fee;

    public Customer(int num, int fee) {
        this.num = num;
        this.fee = fee;
    }

    @Override
    public int compareTo(Customer customer) {
        if (customer.fee > this.fee)
            return 1;
        else if (customer.fee < this.fee)
            return -1;
        return 0;
    }
}