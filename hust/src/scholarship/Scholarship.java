package scholarship;

import java.util.Arrays;
import java.util.Scanner;

public class Scholarship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[][] scores = new long[n][3];
		long[] ranks = new long[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				scores[i][j] = in.nextInt();
			}
			int total = (int) (scores[i][0] + scores[i][1] + scores[i][2]);
			long rank = total * 1000000 + scores[i][0] * 1000 + (300 - i);
			scores[i][0] = total;
			scores[i][1] = rank;
			ranks[i] = rank;
		}

		Arrays.sort(ranks);

		for (int i = n - 1; i >= n - 5; i--) {
			for (int j = 0; j < n; j++) {
				if (scores[j][1] == ranks[i]) {
					System.out.println((j + 1) + " " + scores[j][0]);
				}
			}
		}
		in.close();
	}

}
