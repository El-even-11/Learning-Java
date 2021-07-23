package keyboardRow;

import java.util.ArrayList;
import java.util.HashSet;

public class KeyboardRow {

	public static String[] findWords(String[] words) {

		char[][] allkeys = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
				{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }, { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };

		ArrayList<HashSet<Character>> Keys = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			HashSet<Character> keys = new HashSet<>();
			for (int j = 0; j < allkeys[i].length; j++) {
				keys.add(allkeys[i][j]);
			}
			Keys.add(keys);
		}

		ArrayList<String> ret = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			if (Keys.get(0).contains(words[i].toLowerCase().charAt(0))) {
				int j=1;
				for (;j<words[i].length();j++) {
					if (!Keys.get(0).contains(words[i].toLowerCase().charAt(j))) {
						break;
					}
				}
				if (j==words[i].length()) {
					ret.add(words[i]);
				}
				
			} else if (Keys.get(1).contains(words[i].toLowerCase().charAt(0))) {
				int j=1;
				for (;j<words[i].length();j++) {
					if (!Keys.get(1).contains(words[i].toLowerCase().charAt(j))) {
						break;
					}
				}
				if (j==words[i].length()) {
					ret.add(words[i]);
				}
			} else {
				int j=1;
				for (;j<words[i].length();j++) {
					if (!Keys.get(2).contains(words[i].toLowerCase().charAt(j))) {
						break;
					}
				}
				if (j==words[i].length()) {
					ret.add(words[i]);
				}
			}
		}
		
		return ret.toArray(new String[ret.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]words= {"Hello","Alaska","Dad","Peace"};
		findWords(words);
	}

}
