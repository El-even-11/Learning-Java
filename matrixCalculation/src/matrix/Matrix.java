package matrix;

public class Matrix {

	private Rational[][] nums;
	private int n;

	public Matrix(Rational[][] nums) {
		this.nums = nums;
		this.n = nums.length;
	}

	public void show() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j].show();
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static Rational determinant(Matrix a) {
		if (a.nums.length == 1) {
			return a.nums[0][0];
		}

		Rational ret = new Rational(0, 1);

		for (int i = 0; i < a.nums.length; i++) {

			Rational[][] matrix_new = new Rational[a.nums.length - 1][a.nums.length - 1];

			for (int row = 1; row < a.nums.length; row++) {
				int col_new = 0;
				for (int col = 0; col < a.nums.length; col++) {
					if (col != i) {
						matrix_new[row - 1][col_new++] = a.nums[row][col];
					}
				}
			}
			if (i % 2 == 0) {
				ret = Rational.add(ret, Rational.multiply(a.nums[0][i], Matrix.determinant(new Matrix(matrix_new))));
			} else {
				ret = Rational.add(ret, Rational.multiply(a.nums[0][i], Matrix.determinant(new Matrix(matrix_new))));
				ret = Rational.multiply(ret, new Rational(-1, 1));
			}
		}
		return ret;
	}

	public static Matrix add(Matrix a, Matrix b) {
		Rational[][] ret = new Rational[a.n][a.n];

		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				ret[i][j] = Rational.add(a.nums[i][j], b.nums[i][j]);
			}
		}

		return new Matrix(ret);
	}

	public static Matrix multiply(Matrix a, Matrix b) {

		Rational[][] ret = new Rational[a.n][a.n];

		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				Rational now = new Rational(0, 1);
				for (int k = 0; k < a.n; k++) {
					now = Rational.add(now, Rational.multiply(a.nums[i][k], b.nums[k][j]));
				}
				ret[i][j] = now;
			}
		}

		return new Matrix(ret);
	}
}
