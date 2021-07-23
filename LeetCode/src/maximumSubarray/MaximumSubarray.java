package maximumSubarray;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		int[] maxSub = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			maxSub[i] = nums[i];
		}

		for (int cnt = 1; cnt < nums.length; cnt++) {
			for (int i = 0; i < nums.length - cnt; i++) {
				int sum = 0;
				for (int k = i; k <= i + cnt; k++) {
					sum += nums[k];
				}

				int max_now = Math.max(maxSub[i], maxSub[i + 1]);
				maxSub[i] = Math.max(sum, max_now);

			}
		}

		return maxSub[0];

	}
	
	public static int maxSubArray_two(int[] nums) {
//		int[] maxSub = new int[nums.length];
//		maxSub[0]=nums[0];
//		for (int i=1;i<nums.length;i++) {
//			maxSub[i]=Math.max(maxSub[i-1]+nums[i], nums[i]);
//		}
//		
//		int max=maxSub[0];
//		for (int i=1;i<nums.length;i++) {
//			if (maxSub[i]>max) {
//				max=maxSub[i];
//			}
//		}
//
//		return max;
		
		int pre=nums[0];
		int max=pre;
		for (int i=1;i<nums.length;i++) {
			pre=Math.max(pre+nums[i], nums[i]);
			if (pre>max) {
				max=pre;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray_two(nums));
	}

}
