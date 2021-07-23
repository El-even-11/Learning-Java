package superman;

import java.util.Scanner;

public class Superman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] s = new int[4];
		for (int i = 0; i < s.length; i++) {
			s[i] = in.nextInt();
		}

		int ret = 0;

		for (int i = 0; i < s.length; i++) {
			int[] k = new int[s[i]];
			int time = 0;
			for (int j = 0; j < k.length; j++) {
				k[j] = in.nextInt();
				time += k[j];
			}
			int halftime;
			if (time % 2 == 0) {
				halftime = time / 2;
			} else {
				halftime = time / 2 + 1;
			}

			int[][] bag = new int[k.length + 1][halftime + 1];
			for (int p = 1; p < bag.length; p++) {
				for (int q = 1; q < bag[p].length; q++) {
					if (q < k[p - 1]) {
						bag[p][q] = bag[p - 1][q];
					} else {
						bag[p][q] = Math.max(bag[p - 1][q], bag[p - 1][q - k[p - 1]] + k[p - 1]);
					}
				}
			}

			ret += Math.max(bag[k.length][halftime], time - bag[k.length][halftime]);
		}

		System.out.print(ret);
		in.close();
	}

}
