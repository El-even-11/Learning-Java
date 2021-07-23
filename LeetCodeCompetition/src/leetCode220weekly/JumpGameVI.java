package leetCode220weekly;

public class JumpGameVI {

	public static int maxResult(int[] nums, int k) {
		int[] dp = new int[nums.length];

		dp[0] = nums[0];
		int cnt = 0;

		while (cnt * k < nums.length) {
			for (int i = cnt * k + 1; i <= cnt * k + k && i < nums.length; i++) {
				int max = Integer.MIN_VALUE;

				for (int j = i - 1; j > i - 1 - k; j--) {
					max = max > dp[j] ? max : dp[j];
				}

				dp[i] = max + nums[i];
			}

			cnt++;
		}

		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, -1, -2, 4, -7, 3 };
		System.out.println(maxResult(nums, 2));
	}

}
