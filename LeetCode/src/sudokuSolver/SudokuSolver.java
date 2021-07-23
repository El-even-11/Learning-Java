package sudokuSolver;

public class SudokuSolver {

	char[][] ans;

	int[][] row = new int[9][10];
	int[][] col = new int[9][10];
	int[][] box = new int[9][10];

	public void solveSudoku(char[][] board) {

		ans = board;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char now = ans[i][j];
				int box_index = (i / 3) * 3 + j / 3;

				if (now != '.') {
					row[i][(int) (now - '0')]++;
					col[j][(int) (now - '0')]++;
					box[box_index][(int) (now - '0')]++;
				}
			}
		}

		jColSudoku(0);

	}

	public void jColSudoku(int j) { // 第j列
		if (j == 9) {
			return;
		}

		iRowSudoku(0, j);

		int i;
		for (i = 0; i < 9; i++) {
			if (ans[i][j] == '.') {
				break;
			}
		}
		if (i == 9) {
			jColSudoku(j + 1);
		}
	}

	public void iRowSudoku(int i, int j) { // 第i行
		if (i == 9) {
			return;
		}
		int num = 1;
		if (ans[i][j] == '.') {
			int box_index = (i / 3) * 3 + j / 3;
			for (num = 1; num <= 9; num++) {
				if (row[i][num] == 0 && col[j][num] == 0 && box[box_index][num] == 0) {
					ans[i][j] = (char) (num + '0');

					for (int m = 0; m < 9; m++) {
						for (int n = 0; n < 10; n++) {
							row[m][n] = 0;
							col[m][n] = 0;
							box[m][n] = 0;
						}
					}

					for (int m = 0; m < 9; m++) {
						for (int n = 0; n < 9; n++) {
							char now = ans[m][n];
							int box_index_now = (m / 3) * 3 + n / 3;

							if (now != '.') {
								row[m][(int) (now - '0')] = 1;
								col[n][(int) (now - '0')] = 1;
								box[box_index_now][(int) (now - '0')] = 1;
							}
						}
					}

					iRowSudoku(i + 1, j);
				}
			}
		}
		if (num != 10) {
			iRowSudoku(i + 1, j);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolver test = new SudokuSolver();

		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		test.solveSudoku(board);

	}

}
