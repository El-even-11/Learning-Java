package stringExpansion;

import java.util.Scanner;

public class StringExpansion {

	public static String handle(String a, int p1, int p2, int p3) {

		StringBuilder ret = new StringBuilder();

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '-' && i != 0 && i != a.length() - 1) {
				ret.append(expand(a.charAt(i - 1), a.charAt(i + 1), p1, p2, p3));
			} else {
				ret.append(a.charAt(i));
			}
		}

		return ret.toString();
	}

	public static String expand(char a, char b, int p1, int p2, int p3) {

		if (a == '-' || b == '-') {
			return "-";
		}

		if (a >= '0' && a <= '9' && b >= 'a' && b <= 'z' || a >= 'a' && a <= 'z' && b >= '0' && b <= '9') {
			return "-";
		}

		if (a + 1 == b) {
			return "";
		}

		if (a >= b) {
			return "-";
		}

		StringBuilder ret = new StringBuilder();
		boolean isNum = (a >= '0' && a <= '9');

		char[] gap = new char[b - a - 1];

		for (int i = 0; i < gap.length; i++) {
			if (p1 == 1) {
				gap[i] = (char) (a + i + 1);
			} else if (p1 == 2) {
				gap[i] = isNum ? (char) (a + i + 1) : (char) (a - 'a' + 'A' + i + 1);
			} else {
				gap[i] = '*';
			}
		}

		for (int i = 0; i < gap.length; i++) {
			for (int j = 0; j < p2; j++) {
				ret.append(gap[i]);
			}
		}

		return p3 == 1 ? ret.toString() : reverse(ret.toString());
	}

	public static String reverse(String num) {
		StringBuilder ret = new StringBuilder();

		for (int i = num.length() - 1; i >= 0; i--) {
			ret.append(num.charAt(i));
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int p1, p2, p3;
		Scanner in = new Scanner(System.in);
		p1 = in.nextInt();
		p2 = in.nextInt();
		p3 = in.nextInt();
		in.nextLine();
		String a = in.nextLine();

		System.out.print(handle(a, p1, p2, p3));

		in.close();
	}

}
