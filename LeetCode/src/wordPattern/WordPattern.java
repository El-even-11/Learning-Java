package wordPattern;

import java.util.ArrayList;
import java.util.HashMap;

public class WordPattern {

	public static boolean wordPattern(String pattern, String s) {

		HashMap<Character, String> match = new HashMap<>();
		ArrayList<String> words = new ArrayList<>();
		
		StringBuilder now = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				now.append(s.charAt(i));
			} else {
				words.add(now.toString());
				now.delete(0, now.length());
			}
		}
		words.add(now.toString());

		if (pattern.length() != words.size()) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			if (match.get(pattern.charAt(i)) == null) {
				if (match.containsValue(words.get(i))) {
					return false;
				}
				match.put(pattern.charAt(i), words.get(i));
			} else {
				if (!match.get(pattern.charAt(i)).equals(words.get(i))) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abbc";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));
	}

}
