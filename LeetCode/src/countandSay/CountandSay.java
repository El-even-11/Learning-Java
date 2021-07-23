package countandSay;

import java.util.Scanner;

public class CountandSay {

	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		} else {
			StringBuffer sb = new StringBuffer();
			String s = countAndSay(n - 1);
			int i = 0;
			while (i < s.length()) {
				char char_now = s.charAt(i);
				int j = i;
				int same = 0;
				while (j < s.length()) {
					if (char_now != s.charAt(j)) {
						break;
					} else {
						same++;
					}
					j++;
				}
				if (same != 0) {
					sb.append(same);
					sb.append(char_now);
				}
				i += same;
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countAndSay(5));
	}

}
