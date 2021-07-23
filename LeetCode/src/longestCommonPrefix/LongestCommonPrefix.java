package longestCommonPrefix;

import java.util.Scanner;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		int minStringLength = 100000;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minStringLength) {
				minStringLength = strs[i].length();
			}
		}

		boolean isCommonPrefix = true;
		boolean existCommonPrefix = false;
		int cnt=0;
		char[] CommonPrefix = new char[minStringLength];
		for (int i = 0; i < minStringLength; i++) {
			// check NO.i character
			isCommonPrefix = true;
			char characterNow = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				// check NO.j strs
				if (strs[j].charAt(i) != characterNow) {
					isCommonPrefix = false;
				}
			}
			if (isCommonPrefix) {
				CommonPrefix[i] = characterNow;
				existCommonPrefix = true;
				cnt++;
			} else {
				break;
			}
		}
		
		char []CommonPrefix_solved=new char [cnt];
		for (int i=0;i<cnt;i++) {
			CommonPrefix_solved[i]=CommonPrefix[i];
		}
		
		if (existCommonPrefix) {
			String Common=new String(CommonPrefix_solved);
			return Common;
		} else {
			return "";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix test = new LongestCommonPrefix();
		Scanner in = new Scanner(System.in);
		String[] strs = new String[3];
		for (int i=0;i<3;i++) {
			strs[i]=in.nextLine();
		}
		System.out.println(test.longestCommonPrefix(strs));
	}

}
