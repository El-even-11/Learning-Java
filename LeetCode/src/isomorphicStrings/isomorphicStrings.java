package isomorphicStrings;

import java.util.HashMap;

public class isomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> matchStoT = new HashMap<>();

		boolean isIsomorphic = true;
		for (int i = 0; i < s.length(); i++) {
			if (matchStoT.get(s.charAt(i)) == null) {
				matchStoT.put(s.charAt(i), t.charAt(i));
			} else {
				if (matchStoT.get(s.charAt(i)) != t.charAt(i)) {
					isIsomorphic = false;
				}
			}
		}
		
		HashMap<Character, Character> matchTtoS = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (matchTtoS.get(t.charAt(i)) == null) {
				matchTtoS.put(t.charAt(i), s.charAt(i));
			} else {
				if (matchTtoS.get(t.charAt(i)) != s.charAt(i)) {
					isIsomorphic = false;
				}
			}
		}

		return isIsomorphic;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("ab", "aa"));
	}

}
