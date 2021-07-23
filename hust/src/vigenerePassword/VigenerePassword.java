package vigenerePassword;

import java.util.Scanner;

public class VigenerePassword {

	public static String decipher(String C, String k) {

		StringBuilder M = new StringBuilder();

		for (int i = 0; i < C.length(); i++) {
			M.append(handle(C.charAt(i), k.charAt(i % k.length())));
		}

		return M.toString();
	}

	public static char handle(char c, char k) {

		boolean isLower = (c >= 'a' && c <= 'z');
		c -= (k - 'a');

		if (isLower && c < 'a' || !isLower && c < 'A') {
			c += 26;
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String C, k;
		Scanner in = new Scanner(System.in);
		k = in.nextLine();
		C = in.nextLine();

		k = k.toLowerCase();
		System.out.print(decipher(C, k));

		in.close();
	}

}
