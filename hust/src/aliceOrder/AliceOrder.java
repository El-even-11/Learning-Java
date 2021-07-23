package aliceOrder;

import java.util.Scanner;

public class AliceOrder {

	static int ret = 0;
	static int n;
	static int m;
	static int[] prices;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();

		prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = in.nextInt();
		}

		dfs(0, 0);
		System.out.print(ret);
		in.close();
	}

	public static void dfs(int k, int sum) {
		if (k == n) {
			if (sum == m) {
				ret++;
			}
			return;
		}
		

		dfs(k + 1, sum);

		if (sum < m) {
			sum += prices[k];
			dfs(k + 1, sum);
			sum -= prices[k];
		}
	}

}
