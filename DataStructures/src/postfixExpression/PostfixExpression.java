package postfixExpression;

import java.util.Stack;

public class PostfixExpression {

	public static int calculate(String expression) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char now = expression.charAt(i);
			if (now >= '0' && now <= '9') {
				stack.push(now - '0');
			} else {
				int a = stack.pop();
				int b = stack.pop();
				int c = 0;
				if (now == '+') {
					c = a + b;
				} else if (now == '*') {
					c = a * b;
				}
				stack.push(c);
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate("6523+8*+3+*"));
	}

}
