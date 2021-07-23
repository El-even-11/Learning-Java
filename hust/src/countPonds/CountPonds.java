package countPonds;

import java.util.Scanner;

public class CountPonds {

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
					dfs(i, j);
					cnt++;
				}
			}
		}

		System.out.print(cnt);
		in.close();
	}

	public static void dfs(int I, int J) {
		field[I][J] = '.';

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (I + i >= 0 && J + j >= 0 && I + i < n && J + j < m && field[I + i][J + j] == 'W') {
					dfs(I + i, J + j);
				}
			}
		}
	}

}
