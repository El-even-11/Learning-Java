package implementstrStr;

import java.util.Scanner;

public class Implements_trStr {

	public static int strStr(String haystack, String needle) {
		char[] str1 = haystack.toCharArray();
		char[] str2 = needle.toCharArray();

		if (str2.length==0)return 0;
		
		for (int i = 0; i < str1.length; i++) {
			// check character i in str1
			if (str1.length-i<str2.length)return -1;
			
			boolean isMatch = true;
			for (int j = 0; j < str2.length && i + j < str1.length; j++) {
				if (str2[j] != str1[i + j]) {
					isMatch = false;
				}
			}
			if (isMatch) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner (System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		System.out.println(strStr(s1,s2));
	}

}
