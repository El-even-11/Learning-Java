package splitArrayintoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {

	static List<Integer> ret = new ArrayList<>();

	public static List<Integer> splitIntoFibonacci(String S) {

		backtrack(0, S);

		if (ret.size() < 3) {
			return new ArrayList<>();
		}

		return ret;
	}

	public static boolean backtrack(int n, String S) {
		if (n >= S.length() && ret.size() >= 3) {
			return true;
		}

		for (int j = n; j < S.length(); j++) {
			int size = ret.size();
			String Now = S.substring(n, j + 1);

			if (Now.charAt(0) == '0' && Now.length() > 1) {
				break;
			}
			long now = 0;

			for (int k = 0; k < Now.length(); k++) {
				now = 10 * now + (Now.charAt(k) - '0');
			}

			if (now > Integer.MAX_VALUE) {
				break;
			}

			if (size >= 2 && ret.get(size - 2) + ret.get(size - 1) != now) {
				continue;
			}

			ret.add((int) now);

			if (backtrack(j + 1, S)) {
				return true;
			}

			ret.remove(ret.size() - 1);
			
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitIntoFibonacci("11235813");
	}

}
