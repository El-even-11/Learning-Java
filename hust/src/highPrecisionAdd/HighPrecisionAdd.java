package highPrecisionAdd;

import java.util.Scanner;

public class HighPrecisionAdd {
	public static String add(String num1, String num2, int n) {

		int maxLen = Math.max(num1.length(), num2.length());
		int[] ret = new int[maxLen + 1];
		int[] a = new int[maxLen];
		int[] b = new int[maxLen];

		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) >= '0' && num1.charAt(i) <= '9') {
				a[num1.length() - 1 - i] = num1.charAt(i) - '0';
			} else {
				a[num1.length() - 1 - i] = num1.charAt(i) - 'a' + 10;
			}
		}

		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) >= '0' && num2.charAt(i) <= '9') {
				b[num2.length() - 1 - i] = num2.charAt(i) - '0';
			} else {
				b[num2.length() - 1 - i] = num2.charAt(i) - 'a' + 10;
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
			ans.append(ret[i] < 10 ? (char) (ret[i] + '0') : (char) (ret[i] - 10 + 'a'));
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String a = in.nextLine();
		String b = in.nextLine();
		System.out.print(add(a, b, n));
		in.close();
	}
}
