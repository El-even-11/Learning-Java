package aliceOrder;

import java.util.Scanner;

public class AliceOrderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[] prices = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prices[i] = in.nextInt();
		}

		int[][] f = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j == prices[i]) {
					f[i][j] = f[i - 1][j] + 1;
				} else if (j > prices[i]) {
					f[i][j] = f[i - 1][j] + f[i - 1][j - prices[i]];
				} else {
					f[i][j] = f[i - 1][j];
				}
			}
		}
		System.out.print(f[n][m]);
		in.close();
	}

}
