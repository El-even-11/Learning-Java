package rangeSumQuery;

public class NumArrayII {

	int[] nums;
	int[] sum;

	public NumArrayII(int[] nums) {
		this.nums = nums;
		sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? sum[j] : sum[j] - sum[i - 1];
	}
}
