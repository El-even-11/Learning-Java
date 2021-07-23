package carpet;

import java.util.Scanner;

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] as = new int[N];
		int[] bs = new int[N];
		int[] gs = new int[N];
		int[] ks = new int[N];

		for (int i = 0; i < N; i++) {
			as[i] = in.nextInt();
			bs[i] = in.nextInt();
			gs[i] = in.nextInt();
			ks[i] = in.nextInt();
		}
		int x = in.nextInt();
		int y = in.nextInt();

		for (int i = N - 1; i >= 0; i--) {
			if (x >= as[i] && x <= as[i] + gs[i] && y >= bs[i] && y <= bs[i] + ks[i]) {
				System.out.print(i + 1);
				return;
			}
		}

		System.out.print(-1);
		in.close();
	}

}