package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	static StringBuilder a = new StringBuilder();
	static List<String> ret = new ArrayList<>();

	public static List<String> generateParenthesis(int n) {

		backtrack(1, n);

		return ret;
	}

	public static void backtrack(int k, int n) {
		if (k == 2 * n + 1) {
			int leftCnt = 0;

			for (Character i : a.toString().toCharArray()) {
				if (i == '(') {
					leftCnt++;
				}
			}

			if (leftCnt == a.length() - leftCnt) {
				ret.add(a.toString());
			}
			return;
		}

		a.append('(');

		backtrack(k + 1, n);

		a.deleteCharAt(a.length() - 1);

		int leftCnt = 0;

		for (Character i : a.toString().toCharArray()) {
			if (i == '(') {
				leftCnt++;
			}
		}

		if (leftCnt > a.length() - leftCnt) {
			a.append(')');

			backtrack(k + 1, n);

			a.deleteCharAt(a.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
	}

}
