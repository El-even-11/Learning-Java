package matrix;

public class Calculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational[][] a = new Rational[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = new Rational(1, 3);
			}
		}

		Matrix ma = new Matrix(a);

		Rational[][] b = new Rational[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b[i][j] = new Rational(1, 4);
			}
		}
		b[1][1]=new Rational(1,3);

		Matrix mb = new Matrix(b);

		Matrix mc = Matrix.add(ma, mb);
		Matrix md = Matrix.multiply(ma, mb);
		mc.show();
		md.show();
	}

}
