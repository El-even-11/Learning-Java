package leetCode112801;

public class LeetCode112801 {

	public static int maxRepeating(String sequence, String word) {

		if (sequence.length() < word.length()) {
			return 0;
		}

		int cnt = 0;
		int max = 0;

		int i = 0;
		while (i < sequence.length()) {
			cnt = 0;
			if (word.charAt(0) == sequence.charAt(i)) {
				while (i < sequence.length() && word.charAt(0) == sequence.charAt(i)) {
					int j = 1;
					for (j = 1; j < word.length()&&i+j<sequence.length(); j++) {
						if (word.charAt(j) != sequence.charAt(i + j)) {
							break;
						}
					}
					if (j == word.length()) {
						cnt++;
					} else {
						i++;
						break;
					}
					i += word.length();
				}

				if (cnt > max) {
					max = cnt;
				}

			} else {
				i++;
			}

		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxRepeating("baaba", "ab"));
	}

}
