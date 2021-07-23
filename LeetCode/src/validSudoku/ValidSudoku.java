package validSudoku;

import java.util.HashMap;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashMap<Character, Integer> cntOne = new HashMap<>();
			HashMap<Character, Integer> cntTwo = new HashMap<>();

			for (int j = 1; j <= 9; j++) {
				cntOne.put((char) (j + '0'), 0);
				cntTwo.put((char) (j + '0'), 0);
			}

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					cntOne.put(board[i][j], cntOne.get(board[i][j]) + 1);
					if (cntOne.get(board[i][j]) == 2) {
						return false;
					}
				}
				if (board[j][i] != '.') {
					cntTwo.put(board[j][i], cntTwo.get(board[j][i]) + 1);
					if (cntTwo.get(board[j][i]) == 2) {
						return false;
					}
				}
			}
		}

		for (int p = 0; p < 9; p += 3) {
			for (int q = 0; q < 9; q += 3) {
				HashMap<Character, Integer> cnt = new HashMap<>();
				for (int n = 1; n <= 9; n++) {
					cnt.put((char) (n + '0'), 0);
				}

				for (int i = p; i < p + 3; i++) {
					for (int j = q; j < q + 3; j++) {
						if (board[i][j] != '.') {
							cnt.put(board[i][j], cnt.get(board[i][j]) + 1);
							if (cnt.get(board[i][j]) == 2) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public static boolean isValidSudokuTwo(char[][] board) {
		int[][] row = new int[9][9];
		int[][] col = new int[9][9];
		int[][] box = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				row[i][j] = 0;
				col[i][j] = 0;
				box[i][j] = 0;
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int box_index = (i / 3) * 3 + j / 3;
				char now = board[i][j];

				if (now != '.') {
					row[i][(int) (now - '0') - 1]++;
					col[j][(int) (now - '0') - 1]++;
					box[box_index][(int) (now - '0' - 1)]++;

					if (row[i][(int) (now - '0' - 1)] > 1 || col[j][(int) (now - '0' - 1)] > 1
							|| box[box_index][(int) (now - '0' - 1)] > 1) {
						return false;
					}
				}
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
