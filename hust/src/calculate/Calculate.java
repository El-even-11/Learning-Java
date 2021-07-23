package calculate;

import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] f = new int[1001];

		f[1] = 1;
		f[2] = 2;

		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				f[i] = f[i - 1] + f[i / 2];
			} else {
				f[i] = f[i - 1];
			}
		}

		System.out.print(f[n]);
		in.close();

	}

}
