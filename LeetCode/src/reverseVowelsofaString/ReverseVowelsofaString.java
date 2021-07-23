package reverseVowelsofaString;

import java.util.HashSet;

public class ReverseVowelsofaString {

	public static String reverseVowels(String s) {

		// hashset ´¢´æÔªÒô
		StringBuilder sb = new StringBuilder(s);
		HashSet<Character>vowels=new HashSet<>(){{
			add('a');
			add('e');
			add('i');
			add('o');
			add('u');
			add('A');
			add('E');
			add('I');
			add('O');
			add('U');
			}};
		
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (!vowels.contains(s.charAt(left))&& left < right) {
				left++;
			}
			while (!vowels.contains(s.charAt(right))&& left < right) {
				right--;
			}

			sb.setCharAt(left, s.charAt(right));
			sb.setCharAt(right, s.charAt(left));
			left++;
			right--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aA";
		System.out.println(reverseVowels(s));
	}

}
