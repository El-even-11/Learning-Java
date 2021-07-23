package increasingDecreasingString;

import java.util.HashMap;

public class IncreasingDecreasingString {
	public static String sortString(String s) {
		if (s == "") {
			return "";
		}

		HashMap<Character, Integer> buckets = new HashMap<>();
		StringBuilder ret = new StringBuilder();

		for (char i = 'a'; i <= 'z'; i++) {
			buckets.put(i, 0);
		}

		for (int i = 0; i < s.length(); i++) {
			buckets.put(s.charAt(i), buckets.get(s.charAt(i)) + 1);
		}

		boolean isEmpty = false;

		while (!isEmpty) {

			isEmpty = true;
			for (char i = 'a'; i <= 'z'; i++) {
				if (buckets.get(i) > 0) {
					ret.append(i);
					buckets.put(i, buckets.get(i) - 1);
				}
			}

			for (char i = 'z'; i >= 'a'; i--) {
				if (buckets.get(i) > 0) {
					ret.append(i);
					buckets.put(i, buckets.get(i) - 1);
				}
			}

			for (char i = 'z'; i >= 'a'; i--) {
				if (buckets.get(i) > 0) {
					isEmpty = false;
					break;
				}
			}
		}

		return ret.toString();
	}

	public static void main(String[] args) {

		System.out.println(sortString("leetcode"));
	}
}
