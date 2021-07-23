package chooseNum;

import java.util.Scanner;

public class ChooseNum {

	static int ret = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}

		dfs(0, k, 0, 0, list);

		System.out.print(ret);

		in.close();
	}

	public static void dfs(int k, int K, int sum, int start, int[] list) {
		if (k == K) {
			if (isPrime(sum)) {
				ret++;
			}
			return;
		}

		for (int i = start; i < list.length; i++) {
			dfs(k + 1, K, sum + list[i], i + 1, list);
		}
	}

	public static boolean isPrime(int x) {
		if (x == 1 || x == 0) {
			return false;
		}

		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}

}
