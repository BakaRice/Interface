package csp;

import java.util.Scanner;

public class Solution01 {
	public static void main(String arg[]) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int sum = 0;
		int sumd = 0;
		int max = 0;
		int temp = -1;
		for (int i = 0; i < n; i++) {
			sum = sum + scanner.nextInt();
			sumd = 0;
			for (int j = 1; j <= m; j++) {
				sumd = sumd + scanner.nextInt();
			}
			if (max > sumd) {
				max = sumd;
				temp = i + 1;
			}
			sum = sum + sumd;
		}
		System.out.print(sum + " " + temp + " " + (-max));
	}
}
