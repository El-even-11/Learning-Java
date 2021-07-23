package thirdMaximumNumber;

public class ThirdMaximumNumber {

	public static int thirdMax(int[] nums) {

		long[] max = { Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE };

		int one = 0;
		int two = 0;
		int three = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max[0]) {
				one++;
				max[2] = max[1];
				max[1] = max[0];
				max[0] = nums[i];
			} else if (nums[i] > max[1] && nums[i] != max[0]) {
				two++;
				max[2] = max[1];
				max[1] = nums[i];
			} else if (nums[i] > max[2] && nums[i] != max[1] && nums[i] != max[0]) {
				three++;
				max[2] = nums[i];

			}
		}

		if ((one+two+three)>=3) {
			return (int)max[2];
		} else {
			return (int)max[0];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,-2147483648,2 };
		System.out.println(thirdMax(nums));
	}

}
