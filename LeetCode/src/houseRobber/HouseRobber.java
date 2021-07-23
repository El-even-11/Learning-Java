package houseRobber;

public class HouseRobber {

	public static int rob(int[] nums) {

		int[] maxProfits = new int[nums.length];
		maxProfits[0] = nums[0];
		maxProfits[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < maxProfits.length; i++) {
			maxProfits[i] = Math.max(maxProfits[i - 1], nums[i] + maxProfits[i - 2]);
		}

		return maxProfits[maxProfits.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println(rob(nums));
	}

}
