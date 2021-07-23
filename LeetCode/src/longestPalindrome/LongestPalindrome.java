package longestPalindrome;

public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		int[] cnt = new int[58];

		for (int i = 0; i < 58; i++) {
			cnt[i] = 0;
		}

		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'A']++;
		}

		int ret = 0;

		boolean isOdd=false;
		for (int i = 0; i < 58; i++) {
			if (cnt[i] % 2 == 0) {
				ret += cnt[i];
			} else {
				isOdd=true;
				ret += cnt[i] - 1;
			}
		}

		if (isOdd) {
			return ret+1;
		}else {
			return ret;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome(
				"aaaa"));
	}

}
