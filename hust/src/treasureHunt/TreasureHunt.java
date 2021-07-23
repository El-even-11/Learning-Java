package treasureHunt;

import java.util.Scanner;

public class TreasureHunt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		int[][] room = new int[N][M + 1];
		boolean[][] upstair = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int stair = in.nextInt();
				upstair[i][j] = (stair == 1);
				int x = in.nextInt();
				room[i][j] = x;
				if (upstair[i][j]) {
					room[i][M]++;
				}
			}
		}

		int now = in.nextInt();

		int ret = 0;

		for (int i = 0; i < N; i++) {
			int step = room[i][now];
			ret += step;
			ret %= 20123;
			step--;
			step %= room[i][M];
			step++;
			while (step > 0) {
				if (upstair[i][now]) {
					step--;
					if (step == 0) {
						break;
					} else {
						now++;
					}
				} else {
					now++;
				}
				if (now == M) {
					now = 0;
				}
			}
		}

		System.out.print(ret);
		in.close();

	}

}
