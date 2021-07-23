package plusOne;

public class PlusOne {

	public static int[] plusOne(int[] digits) {

		boolean isAllNine = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				isAllNine = false;
			}
		}

		if (isAllNine) {
			int[] digits_new = new int[digits.length + 1];
			digits_new[0] = 1;
			for (int i = 1; i < digits_new.length; i++) {
				digits_new[i] = 0;
			}
			return digits_new;
		} else {
			digits[digits.length - 1]++;
			for (int i = digits.length - 1; i > 0; i--) {
				if(digits[i]==10) {
					digits[i]=0;
					digits[i-1]++;
				}
			}
			return digits;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 9 };
		System.out.print(plusOne(nums));
	}

}
