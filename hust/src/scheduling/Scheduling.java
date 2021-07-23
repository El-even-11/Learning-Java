package scheduling;

import java.util.Scanner;

public class Scheduling {

	public static int insertTime(boolean[] working, int time, int lasttime) {
		int i = lasttime;
		for (; i < working.length; i++) {
			if (!working[i]) {
				int j = i;
				for (; j < i + time; j++) {
					if (working[j]) {
						break;
					}
				}
				if (j == i + time ) {
					return i;
				} else {
					i = j;
				}
			}
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int m = in.nextInt();
		int n = in.nextInt();
		int[] arrange = new int[m * n];
		for (int i = 0; i < m * n; i++) {
			arrange[i] = in.nextInt() - 1;
		}

		int[][] machine = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				machine[i][j] = in.nextInt() - 1;
			}
		}
		int[][] time = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				time[i][j] = in.nextInt();
			}
		}

		int[] step = new int[n];
		boolean[][] working = new boolean[m][100];
		int[] lasttime = new int[n];

		for (int i = 0; i < m * n; i++) {
			int itemNow = arrange[i];
			int stepNow = step[itemNow];
			step[itemNow]++;
			int timeNow = time[itemNow][stepNow];
			int starttime = insertTime(working[machine[itemNow][stepNow]], timeNow, lasttime[itemNow]);
			for (int j = starttime; j < starttime + timeNow; j++) {
				working[machine[itemNow][stepNow]][j] = true;
			}
			lasttime[itemNow] = starttime + timeNow;
		}

		int max = lasttime[0];
		for (int i = 1; i < n; i++) {
			if (lasttime[i] > max) {
				max = lasttime[i];
			}
		}

		System.out.print(max);
		in.close();
	}

}
