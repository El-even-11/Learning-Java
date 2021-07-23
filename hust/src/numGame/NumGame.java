package numGame;

import java.util.Scanner;

public class NumGame {

	static int n;
	static int m;
	static int[][] a;
	static int max;
	static int ans;
	static int[] di = { 0, 0, 1, 1, -1, -1, 1, -1 };
	static int[] dj = { 1, -1, 1, -1, 1, -1, 0, 0 };
	static int[][] mark;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {
			n = in.nextInt();
			m = in.nextInt();
			a = new int[n][m];
			mark = new int[n][m];
			max = 0;
			ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = in.nextInt();
					mark[i][j] = 0;
				}
			}
			dfs(0, 0);
			System.out.println(max);
		}

		in.close();
	}

	public static void dfs(int I, int J) {
		if (I == n) {
			max = Math.max(max, ans);
			return;
		}

		if (J == m) {
			dfs(I + 1, 0);
			return;
		}

		dfs(I, J + 1);

		if (mark[I][J] == 0) {
			ans += a[I][J];
			for (int i = 0; i < 8; i++) {
				if (I + di[i] >= 0 && I + di[i] < n && J + dj[i] >= 0 && J + dj[i] < m) {
					mark[I + di[i]][J + dj[i]]++;
				}
			}
			dfs(I, J + 1);
			ans -= a[I][J];
			for (int i = 0; i < 8; i++) {
				if (I + di[i] >= 0 && I + di[i] < n && J + dj[i] >= 0 && J + dj[i] < m) {
					mark[I + di[i]][J + dj[i]]--;
				}
			}
		}
	}

}
