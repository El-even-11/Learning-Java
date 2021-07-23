package leetCode43double;

public class ConstructtheLexicographicallyLargestValidSequence {

	static int[] ans;

	public static int[] constructDistancedSequence(int n) {
		ans = new int[2 * n - 1];
		boolean[] used = new boolean[n + 1];

		backtrack(0, new int[2 * n - 1], used, n);
		return ans;
	}

	public static boolean backtrack(int k, int[] now, boolean[] used, int n) {
		if (k == now.length) {
			for (int i = 0; i < now.length; i++) {
				ans[i] = now[i];
			}
			return true;
		}

		if (now[k] != 0) {
			if (backtrack(k + 1, now, used, n)) {
				return true;
			}
			return false;
		}

		for (int i = n; i >= 1; i--) {
			if (i == 1) {

				if (used[i]) {
					continue;
				}

				now[k] = 1;
				used[1] = true;

				if (backtrack(k + 1, now, used, n)) {
					return true;
				}
				if (now[k] == i) {
					now[k] = 0;
					used[1] = false;
				}

			} else {

				if (used[i]) {
					continue;
				}

				if (k + i >= now.length || now[k + i] != 0) {
					continue;
				}

				now[k] = i;
				now[k + i] = i;
				used[i] = true;

				if (backtrack(k + 1, now, used, n)) {
					return true;
				}
				if (now[k] == i) {
					now[k] = 0;
					used[i] = false;
				}
				if (now[k + i] == i) {
					now[k + i] = 0;
				}

			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructDistancedSequence(5);
	}

}
