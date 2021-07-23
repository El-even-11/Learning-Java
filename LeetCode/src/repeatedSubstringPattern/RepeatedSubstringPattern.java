package repeatedSubstringPattern;

public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String s) {

		StringBuilder sub = new StringBuilder();

		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			sub.append(s.charAt(i));

			if (s.length() % (i + 1) == 0) {
				int j = 1;
				for (j = 1; j < len / (i + 1); j++) {
					if (!s.subSequence(j * (i + 1), (j + 1) * (i + 1)).equals(sub.toString())) {
						break;
					}
				}
				if (j == len / (i + 1)) {
					return true;
				}
			}
		}

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("abcabcabca"));
	}

}
