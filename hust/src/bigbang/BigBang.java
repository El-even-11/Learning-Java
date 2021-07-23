package bigbang;

import java.util.Scanner;

public class BigBang {

	public static int judge(int a, int b) {

		if (a == 0 && b == 0 || a == 1 && b == 1 || a == 2 && b == 2 || a == 3 && b == 3 || a == 4 && b == 4) {
			return 0;
		} else if (a == 1 && b == 0 || a == 2 && b == 1 || a == 3 && b == 2 || a == 4 && b == 0 || a == 4 && b == 1
				|| a == 0 && b == 2 || a == 0 && b == 3 || a == 1 && b == 3 || a == 2 && b == 4 || a == 3 && b == 4) {
			return -1;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Ta = in.nextInt();
		int Tb = in.nextInt();
		int[] a = new int[Ta];
		int[] b = new int[Tb];
		for (int i = 0; i < Ta; i++) {
			a[i] = in.nextInt();
		}

		for (int i = 0; i < Tb; i++) {
			b[i] = in.nextInt();
		}

		int acnt = 0;
		int bcnt = 0;
		for (int i = 0; i < N; i++) {
			int ret = judge(a[i % Ta], b[i % Tb]);
			if (ret == 1) {
				acnt++;
			} else if (ret == -1) {
				bcnt++;
			}
		}

		System.out.print(acnt + " " + bcnt);
		in.close();
	}

}
