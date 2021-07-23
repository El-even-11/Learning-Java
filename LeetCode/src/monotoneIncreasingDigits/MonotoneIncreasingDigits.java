package monotoneIncreasingDigits;

import java.util.ArrayList;

public class MonotoneIncreasingDigits {

	public static int monotoneIncreasingDigits(int N) {

		ArrayList<Integer> nums = new ArrayList<>();

		while (N > 0) {
			nums.add(N % 10);
			N /= 10;
		}

		int len = nums.size();
		int[] digits = new int[len];

		for (int i = 0; i < len; i++) {
			digits[i] = nums.get(len - i - 1);
		}

		int i = 0;
		for (i = 0; i < len - 1; i++) {
			if (digits[i] > digits[i + 1]) {
				break;
			}
		}

		if (i == len - 1) {
			return N;
		}

		for (int j = i + 1; j < len; j++) {
			digits[j] = 9;
		}

		digits[i]--;

		while (i > 0) {
			if (digits[i - 1] > digits[i]) {
				digits[i] = 9;
				digits[i - 1]--;
			}
			i--;
		}

		int ret = 0;

		for (int j = 0; j < len; j++) {
			ret = ret * 10 + digits[j];
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(monotoneIncreasingDigits(1234));
	}

}
