package countPonds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountPondsII {
	static char[][] field;
	static int n;
	static int m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		field = new char[n][m];
		String[] line = new String[n];

		for (int i = 0; i < n; i++) {
			line[i] = in.nextLine();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				field[i][j] = line[i].charAt(j);
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == 'W') {
					bfs(i, j);
					cnt++;
				}
			}
		}

		System.out.print(cnt);
		in.close();
	}

	public static void bfs(int I, int J) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[] { I, J });
		field[I][J] = '.';

		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (temp[0] + i >= 0 && temp[1] + j >= 0 && temp[0] + i < n && temp[1] + j < m
							&& field[temp[0] + i][temp[1] + j] == 'W') {
						queue.offer(new Integer[] { temp[0] + i, temp[1] + j });
						field[temp[0] + i][temp[1] + j]='.';
					}
				}
			}
		}
	}
}
