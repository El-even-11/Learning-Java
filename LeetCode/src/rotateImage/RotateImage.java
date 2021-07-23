package rotateImage;

public class RotateImage {

	public void rotate(int[][] matrix) {

		int n = matrix.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
