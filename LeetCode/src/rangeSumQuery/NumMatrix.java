package rangeSumQuery;

public class NumMatrix {

	public int[][] sums;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		sums = new int[matrix.length][matrix[0].length];
		sums[0][0] = matrix[0][0];
		
		for (int i = 1; i < matrix.length; i++) {
			sums[i][0] = sums[i - 1][0] + matrix[i][0];
		}
		for (int i = 1; i < matrix[0].length; i++) {
			sums[0][i] = sums[0][i - 1] + matrix[0][i];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				sums[i][j] = matrix[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (row1 == 0 && col1 == 0) {
			return sums[row2][col2];
		} else if (row1 == 0) {
			return sums[row2][col2] - sums[row2][col1 - 1];
		} else if (col1 == 0) {
			return sums[row2][col2] - sums[row1 - 1][col2];
		} else {
			return sums[row2][col2] - sums[row2][col1 - 1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix obj = new NumMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(obj.sums[i][j] + " ");
			}
			System.out.println();
		}
		obj.sumRegion(2, 1, 4, 3);
		obj.sumRegion(1, 1, 2, 2);
		obj.sumRegion(1, 2, 2, 4);
	}

}
