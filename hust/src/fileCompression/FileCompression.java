package fileCompression;

import java.util.Arrays;
import java.util.Scanner;

public class FileCompression {

	public static String decompress(char[] s, int p) {
		StringBuilder ret = new StringBuilder();

		char[] sort = new char[s.length];
		for (int i = 0; i < s.length; i++) {
			sort[i] = s[i];
		}

		Arrays.sort(sort);
		p--;
		boolean[] used = new boolean[s.length];

		for (int i = 0; i < s.length; i++) {
			if (sort[i] == s[p]) {
				used[i] = true;
				p = i;
				ret.append(s[p]);
				break;
			}
		}

		for (int i = 0; i < s.length - 1; i++) {
			for (int j = s.length - 1; j >= 0; j--) {
				if (sort[j] == s[p] && !used[j]) {
					p = j;
					used[j] = true;
					ret.insert(0, s[p]);
					break;
				}
			}
		}

		return ret.toString();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		in.nextLine();
		String s = in.nextLine();
		int p = in.nextInt();

		System.out.println(decompress(s.toCharArray(), p));
		in.close();
	}

}
