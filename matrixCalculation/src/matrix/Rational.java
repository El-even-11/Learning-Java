package matrix;

public class Rational {

	private int num;
	private int den;

	private void simplify() {
		int Gcd = gcd(Math.abs(num), Math.abs(den));
		num = num / Gcd;
		den = den / Gcd;
	}

	private int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

	public Rational(int num, int den) {
		this.num = num;
		this.den = den;
		simplify();
	}

	public void show() {
		if (den == 1) {
			System.out.print(num);
		} else {
			if (num * den > 0) {
				System.out.print(Math.abs(num) + "/" + Math.abs(den));
			} else {
				System.out.print("-" + Math.abs(num) + "/" + Math.abs(den));
			}
		}
	}

	public static Rational add(Rational a, Rational b) {
		int num = a.num * b.den + a.den * b.num;
		int den = a.den * b.den;

		return new Rational(num, den);
	}

	public static Rational multiply(Rational a, Rational b) {
		int num = a.num * b.num;
		int den = a.den * b.den;

		return new Rational(num, den);
	}
}
