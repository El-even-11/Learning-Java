package validParentheses;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

	static boolean isLeftParentheses(char a) {
		if (a == '(' || a == '[' || a == '{')
			return true;
		else
			return false;
	}

	static boolean isRightParentheses(char a) {
		if (a == ')' || a == ']' || a == '}')
			return true;
		else
			return false;
	}

	static boolean isMatch(char a, char b) {
		boolean isMatch = false;
		if (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}') {
			isMatch = true;
		}

		return isMatch;
	}

	public static boolean isValid(String s) {
		char str[] = s.toCharArray();
		Stack<Character> parentheses = new Stack<Character>();

		for (int i = 0; i < str.length; i++) {
			if (isRightParentheses(str[i]) && parentheses.isEmpty()) {
				return false;
			}
				if (isLeftParentheses(str[i])) {
					parentheses.push(str[i]);
				}
			if (isRightParentheses(str[i]) && isMatch(parentheses.lastElement(), str[i])) {
				parentheses.pop();
			}
		}

		return parentheses.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(isValid(s));
	}

}
