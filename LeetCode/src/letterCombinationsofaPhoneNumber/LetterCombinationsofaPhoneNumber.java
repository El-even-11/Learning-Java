package letterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	static HashMap<Integer, HashSet<Character>> words = new HashMap<>();
	static List<String> ret = new ArrayList<>();
	static StringBuilder a = new StringBuilder();

	public static List<String> letterCombinations(String digits) {
		HashSet<Character> word2 = new HashSet<>();
		word2.add('a');
		word2.add('b');
		word2.add('c');
		words.put(2, word2);

		HashSet<Character> word3 = new HashSet<>();
		word3.add('d');
		word3.add('e');
		word3.add('f');
		words.put(3, word3);

		HashSet<Character> word4 = new HashSet<>();
		word4.add('g');
		word4.add('h');
		word4.add('i');
		words.put(4, word4);

		HashSet<Character> word5 = new HashSet<>();
		word5.add('j');
		word5.add('k');
		word5.add('l');
		words.put(5, word5);

		HashSet<Character> word6 = new HashSet<>();
		word6.add('m');
		word6.add('n');
		word6.add('o');
		words.put(6, word6);

		HashSet<Character> word7 = new HashSet<>();
		word7.add('q');
		word7.add('p');
		word7.add('r');
		word7.add('s');
		words.put(7, word7);

		HashSet<Character> word8 = new HashSet<>();
		word8.add('t');
		word8.add('u');
		word8.add('v');
		words.put(8, word8);

		HashSet<Character> word9 = new HashSet<>();
		word9.add('w');
		word9.add('x');
		word9.add('y');
		word9.add('z');
		words.put(9, word9);

		backtrack(0, digits);
		
		return ret;
	}

	public static void backtrack(int k, String digits) {
		if (k == digits.length()) {
			ret.add(a.toString());
			return;
		}

		for (Character i : words.get(digits.charAt(k) - '0')) {
			a.append(i);
			
			backtrack(k+1, digits);
			
			a.deleteCharAt(a.length()-1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("23");
	}

}
