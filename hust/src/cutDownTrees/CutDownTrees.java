package cutDownTrees;

import java.util.Scanner;

public class CutDownTrees {

	static int m;
	static int[] trees;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		m = in.nextInt();
		int max = 0;
		trees = new int[n];
		for (int i = 0; i < n; i++) {
			trees[i] = in.nextInt();
			if (max < trees[i]) {
				max = trees[i];
			}
		}

		int l = 0;
		int r = max;
		int ans = 0;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (judge(mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		System.out.print(ans);
		in.close();
	}

	public static boolean judge(int x) {
		long all = 0;
		for (int i = 0; i < trees.length; i++) {
			all += (trees[i] - x) > 0 ? trees[i] - x : 0;
		}
		if (all >= m) {
			return true;
		} else {
			return false;
		}
	}

}
