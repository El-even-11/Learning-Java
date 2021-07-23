package removeDuplicateLetters;

import java.util.Stack;

public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {

		Stack<Character> stack = new Stack<>();
		int[] cnt = new int[26];
		boolean[] exist = new boolean[26];

		for (Character i : s.toCharArray()) {
			cnt[i - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (!exist[s.charAt(i) - 'a']) {
				while (!stack.isEmpty() && s.charAt(i) < stack.peek() && cnt[stack.peek() - 'a'] > 0) {
					exist[stack.pop() - 'a'] = false;
				}
				stack.push(s.charAt(i));
				exist[stack.peek() - 'a'] = true;
			}
			cnt[s.charAt(i) - 'a']++;
		}

		StringBuilder ret = new StringBuilder();

		while (!stack.isEmpty()) {
			ret.insert(0, stack.pop());
		}

		return ret.toString();
	}

	public static void main(String[] args) {

	}
}
