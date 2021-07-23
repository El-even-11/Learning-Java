package wiggleSubsequence;

public class WiggleSubsequence {

	public static int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int k = 0;
		while (k + 1 < nums.length && nums[k + 1] == nums[k]) {
			k++;
		}
		if (k == nums.length) {
			return 1;
		}

		boolean up = (nums[k + 1] - nums[k]) > 0;
		int ret = 1;
		for (int i = k + 1; i < nums.length; i++) {
			if (up && nums[i] - nums[i - 1] > 0) {
				ret++;
				up = false;
			} else if (!up && nums[i] - nums[i - 1] < 0) {
				ret++;
				up = true;
			}

		}

		return ret;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 7, 4, 9, 2, 5 };
		System.out.println(wiggleMaxLength(nums));
	}

}
