package minimumMove;

public class MinimumMove {
	public static int minMoves(int[] nums) {

		int min = Integer.MAX_VALUE;

		long sum=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			sum+=nums[i];
		}
		
		return (int)sum-min*nums.length;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2147483647 };
		System.out.println(minMoves(nums));
	}

}
