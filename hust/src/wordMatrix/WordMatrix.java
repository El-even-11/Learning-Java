package wordMatrix;

import java.util.Scanner;

public class WordMatrix {

	static boolean[][] show;
	static char[][] m;
	static String tar = "yizhong";
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();

		m = new char[n][n];
		show = new boolean[n][n];
		String[] lines = new String[n];

		for (int i = 0; i < n; i++) {
			lines[i] = in.nextLine();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = lines[i].charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (m[i][j] == 'y') {
					search(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (show[i][j]) {
					System.out.print(m[i][j]);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		in.close();
	}

	public static void search(int I, int J) {
		search1(I, J);
		search2(I, J);
		search3(I, J);
		search4(I, J);
		search5(I, J);
		search6(I, J);
		search7(I, J);
		search8(I, J);
	}

	public static void search1(int I, int J) { // 从左到右
		if (J + 7 > n) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = J; k < J + 7; k++) {
			sb.append(m[I][k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = J; k < J + 7; k++) {
				show[I][k] = true;
			}
		}
	}

	public static void search2(int I, int J) { // 从右到左
		if (J < 6) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = J; k > J - 7; k--) {
			sb.append(m[I][k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = J; k > J - 7; k--) {
				show[I][k] = true;
			}
		}
	}

	public static void search3(int I, int J) { // 从上到下
		if (I + 7 > n) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = I; k < I + 7; k++) {
			sb.append(m[k][J]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = I; k < I + 7; k++) {
				show[k][J] = true;
			}
		}
	}

	public static void search4(int I, int J) {
		if (I < 6) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = I; k > I - 7; k--) {
			sb.append(m[k][J]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = I; k > I - 7; k--) {
				show[k][J] = true;
			}
		}
	}

	public static void search5(int I, int J) { // 从左上到右下
		if (I + 7 > n || J + 7 > n) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < 7; k++) {
			sb.append(m[I + k][J + k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = 0; k < 7; k++) {
				show[I + k][J + k] = true;
			}
		}
	}

	public static void search6(int I, int J) { // 从右下到左上
		if (I < 6 || J < 6) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < 7; k++) {
			sb.append(m[I - k][J - k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = 0; k < 7; k++) {
				show[I - k][J - k] = true;
			}
		}
	}

	public static void search7(int I, int J) { // 从右上到左下
		if (I + 7 > 6 || J < 6) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < 7; k++) {
			sb.append(m[I + k][J - k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = 0; k < 7; k++) {
				show[I + k][J - k] = true;
			}
		}
	}

	public static void search8(int I, int J) {
		if (I < 6 || J + 7 > n) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < 7; k++) {
			sb.append(m[I - k][J + k]);
		}

		if (tar.equals(sb.toString())) {
			for (int k = 0; k < 7; k++) {
				show[I - k][J + k] = true;
			}
		}
	}

}
