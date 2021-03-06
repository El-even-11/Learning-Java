package factorialTrailingZeroes;

public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		// O(n)
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = i * fac[i - 1];
		}

		int cnt = 0;
		while (fac[n] != 0) {
			if (fac[n] % 10 == 0) {
				cnt++;
			} else {
				break;
			}
			fac[n] /= 10;
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(13));
	}

}
