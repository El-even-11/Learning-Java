package ransomNote;

import java.util.HashMap;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {

		HashMap<Character, Integer> char_cnt = new HashMap<>();

		for (int i = 0; i < magazine.length(); i++) {
			char now = magazine.charAt(i);
			char_cnt.put(now, char_cnt.getOrDefault(now, 0) + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char now = ransomNote.charAt(i);
			if (!char_cnt.containsKey(now) || char_cnt.get(now) == 0) {
				return false;
			}
			char_cnt.put(now, char_cnt.get(now) - 1);
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
