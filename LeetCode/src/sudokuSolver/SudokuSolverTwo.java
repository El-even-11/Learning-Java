package sudokuSolver;

public class SudokuSolverTwo {

	char[][] ans;
	char[][][] all = new char[81][9][9];

	public void solveSudoku(char[][] board) {

		ans = board;
		kSudoku(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = ans[i][j];
			}
		}

		if (board[8][8] != '.') {
			return;
		}
		boolean[] exist = new boolean[10];
		for (int i = 0; i < 8; i++) {
			exist[(int) (board[8][i] - '0')] = true;
		}
		for (int i = 0; i < 9; i++) {
			if (!exist[i]) {
				board[8][8] = (char) (i + '0');
			}
		}
	}

	public void kSudoku(int k) {

		if (k == 81) {
			ans = all[80];
			return;
		}

		if (k == 0) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					all[0][i][j] = ans[i][j];
				}
			}
		} else {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					all[k][i][j] = all[k - 1][i][j];
				}
			}
		}

		int i = k / 9;
		int j = k % 9;

		if (all[k][i][j] == '.') {
			int num = 1;
			for (num = 1; num <= 9; num++) {
				if (isValidSudoku(num, i, j, all[k])) {
					all[k][i][j] = (char) (num + '0');

					kSudoku(k + 1);
				}
			}
		} else {
			kSudoku(k + 1);
		}

	}

	public boolean isValidSudoku(int num, int m, int n, char[][] kborad) {

		kborad[m][n] = (char) (num + '0');

		int[][] row = new int[9][10];
		int[][] col = new int[9][10];
		int[][] box = new int[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				row[i][j] = 0;
				col[i][j] = 0;
				box[i][j] = 0;
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int box_index = (i / 3) * 3 + j / 3;
				char now = kborad[i][j];

				if (now != '.') {
					row[i][(int) (now - '0')]++;
					col[j][(int) (now - '0')]++;
					box[box_index][(int) (now - '0')]++;

					if (row[i][(int) (now - '0')] > 1 || col[j][(int) (now - '0')] > 1
							|| box[box_index][(int) (now - '0')] > 1) {
						kborad[m][n] = '.';
						return false;
					}
				}
			}
		}
		kborad[m][n] = '.';
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolverTwo test = new SudokuSolverTwo();

		char[][] board = { 
				{ '.', '3', '.', '.', '.', '7', '.', '.', '4' },
				{ '6', '.', '2', '.', '4', '1', '.', '.', '.' }, 
				{ '.', '5', '.', '.', '3', '.', '9', '6', '7' },
				{ '.', '4', '.', '.', '.', '3', '.', '.', '6' }, 
				{ '.', '8', '7', '.', '.', '.', '3', '5', '.' },
				{ '9', '.', '.', '7', '.', '.', '.', '2', '.' },
				{ '7', '1', '8', '.', '2', '.', '.', '4', '.' },
				{ '.', '.', '.', '1', '6', '.', '8', '.', '9' },
				{ '4', '.', '.', '5', '.', '.', '.', '3', '.' } };

		test.solveSudoku(board);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}

	}
}
