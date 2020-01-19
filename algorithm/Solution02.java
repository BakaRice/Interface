package csp;
import java.util.Scanner;

public class Solution02 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int allsum = 0;
		int sum = 0;
		int d = 0;
		int e = 0;
		int [] tree = new int[n];
		for (int i = 0; i < n; i++) {
			int p = scanner.nextInt();
			for (int j = 0; j < p; j++) {
				int temp = scanner.nextInt();
				if (temp>0) {
					if (sum!=temp&&j!=0&&tree[i]!=1) {
						d++;
						tree[i] = 1;
					}
					sum = temp;
				}else {
				  sum  = sum + temp;
				}
			}
			allsum = allsum + sum;
		}
		//if (tree.length>=3)
		for (int i = 0; i < tree.length; i++) {
			int j = tree[(i-1+n)%n]+tree[i]+tree[(i+1+n)%n];
			if (j==3) e++;
		}
		System.out.print(allsum+" "+d+" "+e);
	}
}
