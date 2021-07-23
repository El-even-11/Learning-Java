package houseRobber;

public class HouseRobberII {

	public static int rob(int[] nums) {

		int len = nums.length;

		int dp1[] = new int[len];

		dp1[0] = nums[0];
		dp1[1] = nums[0];
		for (int i = 2; i < len - 1; i++) {
			dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
		}

		int dp2[] = new int[len];

		dp2[0] = 0;
		dp2[1] = nums[1];

		for (int i = 2; i < len; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
		}

		return Math.max(dp1[len - 2], dp2[len - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 2 };
		System.out.println(rob(nums));
	}

}
