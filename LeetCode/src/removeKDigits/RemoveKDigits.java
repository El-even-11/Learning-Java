package removeKDigits;

import java.util.Stack;

public class RemoveKDigits {

	public static String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<>();

		int remain = num.length() - k;
		for (int i = 0; i < num.length(); i++) {
			while (!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}

		StringBuilder ret = new StringBuilder();

		while (!stack.isEmpty()) {
			ret.insert(0, stack.pop());
		}

		while (true) {
			if (ret.length() > 0 && ret.charAt(0) == '0') {
				ret.delete(0, 1);
			} else {
				break;
			}
		}

		while (ret.length() > remain) {
			ret.delete(remain, remain + 1);
		}

		if (ret.length() == 0) {
			return "0";
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("1111111", 3));
	}

}
