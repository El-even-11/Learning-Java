package removeDuplicates;

import java.util.Scanner;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		int len = 0;
		int i = 0;
		while (i < nums.length) {
			// check a[i] is exist or not
			boolean isDuplicates = false;
			for (int j = len - 1; j >= 0; j--) {
				if (nums[len] == nums[j]) {
					isDuplicates = true;
					for (int k = len; k < nums.length - 1; k++) {
						nums[k] = nums[k + 1];
					}
				}
			}
			if (!isDuplicates)
				len++;
			i++;
		}

		return len;
	}

	public static void main(String[] args) {

	}

}
