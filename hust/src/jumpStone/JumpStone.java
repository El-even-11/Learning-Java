package jumpStone;

import java.util.Scanner;

public class JumpStone {

	static int[] s;
	static int m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int L = in.nextInt();
		int n = in.nextInt();
		m = in.nextInt();
		s = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			s[i] = in.nextInt();
		}
		s[n + 1] = L;

		int l = 1;
		int r = L;
		int mid = 0;
		while (l < r) {
			mid = (l + r) / 2;
			if (judge(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		System.out.print(mid);

		in.close();
	}

	public static boolean judge(int x) {
		int i = 1;
		int now = 0;
		int cnt = 0;
		while (i < s.length) {
			if (s[i] - s[now] < x) {
				cnt++;
			} else {
				now = i;
			}
			i++;
		}
		if (cnt > m) {
			return false;
		} else {
			return true;
		}
	}

}
