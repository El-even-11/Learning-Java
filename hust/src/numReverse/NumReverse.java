package numReverse;

import java.util.Scanner;

public class NumReverse {

	public static String add(String num1, String num2, int n) {
		int[] a = new int[num1.length()];
		int[] b = new int[num2.length()];
		int maxLen = Math.max(num1.length(), num2.length());
		int[] ret = new int[maxLen + 1];

		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) >= '0' && num1.charAt(i) <= '9') {
				a[num1.length() - 1 - i] = num1.charAt(i) - '0';
			} else {
				a[num1.length() - 1 - i] = num1.charAt(i) - 'A' + 10;
			}
		}

		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) >= '0' && num2.charAt(i) <= '9') {
				b[num2.length() - 1 - i] = num2.charAt(i) - '0';
			} else {
				b[num2.length() - 1 - i] = num2.charAt(i) - 'A' + 10;
			}
		}

		for (int i = 0; i < maxLen; i++) {
			ret[i] += a[i] + b[i];
			ret[i + 1] += ret[i] / n;
			ret[i] %= n;
		}

		if (ret[maxLen] > 0) {
			maxLen++;
		}

		StringBuilder ans = new StringBuilder();

		for (int i = maxLen - 1; i >= 0; i--) {
			ans.append(ret[i] < 10 ? (char) (ret[i] + '0') : (char) (ret[i] - 10 + 'A'));
		}

		return ans.toString();
	}

	public static String reverse(String num) {
		StringBuilder ret = new StringBuilder();

		for (int i = num.length() - 1; i >= 0; i--) {
			ret.append(num.charAt(i));
		}

		return ret.toString();
	}

	public static boolean isReverse(String num) {

		return num.equals(reverse(num));
	}

	public static void main(String[] args) {
		int N;
		String M;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		in.nextLine();
		M = in.nextLine();

		int step = 0;

		while (step <= 30) {
			if (isReverse(M)) {
				System.out.print("STEP=" + step);
				return;
			}

			M = add(M, reverse(M), N);
			step++;
		}

		System.out.print("Impossible!");
		in.close();
	}

}
