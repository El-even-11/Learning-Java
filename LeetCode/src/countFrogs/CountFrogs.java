package countFrogs;

public class CountFrogs {

	public static int minNumberOfFrogs(String croakOfFrogs) {

		int c = 0;
		int r = 0;
		int o = 0;
		int a = 0;
		int k = 0;

		for (int i = 0; i < croakOfFrogs.length(); i++) {
			if (croakOfFrogs.charAt(i) == 'c')
				c++;
			if (croakOfFrogs.charAt(i) == 'r')
				r++;
			if (croakOfFrogs.charAt(i) == 'o')
				o++;
			if (croakOfFrogs.charAt(i) == 'a')
				a++;
			if (croakOfFrogs.charAt(i) == 'k')
				k++;

			if (c < r || r < o || o < a || a < k) {
				return -1;
			}
		}

		if (c != k) {
			return -1;
		}

		int max = 0;

		c=0;
		k=0;
		for (int i = 0; i < croakOfFrogs.length(); i++) {
			if (croakOfFrogs.charAt(i) == 'c') {
				c++;
			}
			if (croakOfFrogs.charAt(i) == 'k') {
				max = max > c ? max : c;
				c--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minNumberOfFrogs("croacrkoakcroak"));
	}

}
