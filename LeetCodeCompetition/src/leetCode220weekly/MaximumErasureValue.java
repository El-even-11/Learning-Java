package leetCode220weekly;

import java.util.Arrays;

public class MaximumErasureValue {

	public static int maximumUniqueSubarray(int[] nums) {

		int[] dp = new int[nums.length];
		int[] pos = new int[nums.length];
		int[] sum = new int[nums.length];

		dp[0] = nums[0];
		pos[0] = 0;
		sum[0] = nums[0];
		int[] map = new int[10001];
		Arrays.fill(map, -1);
		map[nums[0]] = 0;
		int ret = nums[0];

		for (int i = 1; i < dp.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
			if (map[nums[i]] != -1) {
				dp[i] = sum[i] - sum[map[nums[i]]];
				pos[i] = map[nums[i]] + 1;
				for (int k = pos[i - 1]; k < map[nums[i]]; k++) {
					map[nums[k]] = -1;
				}
				map[nums[i]] = i;
			} else {
				dp[i] = dp[i - 1] + nums[i];
				map[nums[i]] = i;
				pos[i] = pos[i - 1];
			}

			ret = ret > dp[i] ? ret : dp[i];
		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
		System.out.println(maximumUniqueSubarray(nums));
	}

}
