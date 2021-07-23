package leetCode43double;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {

	public int maximumGain(String s, int x, int y) {
		Stack<Character> a = new Stack<>();
		Stack<Character> b = new Stack<>();

		if (y > x) {
			int sum = 0;
			for (char c : s.toCharArray()) {
				if (a.isEmpty()) {
					a.push(c);
				} else {
					if (a.peek() == 'b' && c == 'a') {
						a.pop();
						sum += y;
					} else {
						a.push(c);
					}
				}
			}

			while (!a.isEmpty()) {
				if (b.isEmpty()) {
					b.push(a.pop());
				} else {
					if (a.peek() == 'a' && b.peek() == 'b') {
						a.pop();
						b.pop();
						sum += x;
					} else {
						b.push(a.pop());
					}
				}
			}

			return sum;

		} else {
			int sum = 0;
			for (char c : s.toCharArray()) {
				if (a.isEmpty()) {
					a.push(c);
				} else {
					if (a.peek() == 'a' && c == 'b') {
						a.pop();
						sum += x;
					} else {
						a.push(c);
					}
				}
			}

			while (!a.isEmpty()) {
				if (b.isEmpty()) {
					b.push(a.pop());
				} else {
					if (a.peek() == 'b' && b.peek() == 'a') {
						a.pop();
						b.pop();
						sum += y;
					} else {
						b.push(a.pop());
					}
				}
			}

			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
