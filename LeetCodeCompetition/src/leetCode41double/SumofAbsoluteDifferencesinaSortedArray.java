package leetCode41double;

import java.util.HashMap;

public class SumofAbsoluteDifferencesinaSortedArray {

	public static int[] getSumAbsoluteDifferences(int[] nums) {

		int len = nums.length;
		HashMap<Integer, Integer> abs = new HashMap<>();
		int[] ret = new int[len];

		for (int i = 0; i < len; i++) {
			if (abs.containsKey(nums[i])) {
				ret[i] = abs.get(nums[i]);
			} else {
				int sum = 0;
				for (int j = 0; j < len; j++) {

					sum += Math.abs(nums[i] - nums[j]);
				}
				abs.put(nums[i], sum);
				ret[i] = sum;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
