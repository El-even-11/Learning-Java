package matrix;

import java.util.Scanner;

public class Matrix {

	Scanner in = new Scanner(System.in);
	int n = input_n();
	double[][] matrix_one = new double[n][n];
	double[][] matrix_two = new double[n][n];
	double[][] matrix_temp = new double[n][n];

	int input_n() {
		System.out.print("Please input the order of matrix : ");
		return in.nextInt();
	}

	void read_in_matrix(int type) {
		if (type == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix_one[i][j] = in.nextDouble();
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix_two[i][j] = in.nextDouble();
				}
			}
		}
	}

	void multiply() {
		double sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// calculate matrix_temp[i][j]
				for (int k = 0; k < n; k++) {
					sum += matrix_one[i][k] * matrix_two[k][j];
				}
				matrix_temp[i][j] = sum;
				sum = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix_one[i][j] = matrix_temp[i][j];
			}
		}
	}

	void show_result(int matrix[][]) {
		System.out.println("The result is : ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	//计算n阶行列式
	public static int determinant(int matrix[][]) {
		if (matrix.length == 1)
			return matrix[0][0];
		else {
			int sum = 0;
			for (int i = 0; i < matrix.length; i++) {
				int col_new = 0;
				int[][] matrix_new = new int[matrix.length - 1][matrix.length - 1];
				for (int row = 1; row < matrix.length; row++) {
					col_new = 0;
					for (int col = 0; col < matrix.length; col++) {
						if (col != i)
							matrix_new[row-1][col_new++] = matrix[row][col];
					}
				}
				if (i % 2 == 0)
					sum += matrix[0][i] * determinant(matrix_new);
				else
					sum -= matrix[0][i] * determinant(matrix_new);
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Matrix mat = new Matrix();
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		
		int[][] matrix = new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				matrix[i][j]=in.nextInt();
			}
		}
		
		System.out.print(determinant(matrix));
	}

}
