package relativeRanks;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {

	public String[] findRelativeRanks(int[] nums) {
		HashMap<Integer, Integer> rank = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			rank.put(nums[i], i); // nums[i]在第i个位置
		}

		Arrays.sort(nums);

		String[] ret = new String[nums.length];

		for (int i = 0; i < nums.length - 3; i++) {
			ret[rank.get(nums[i])] = "" + (nums.length - i);
		}
		if (nums.length >= 3) {
			ret[rank.get(nums[nums.length - 3])] = "Bronze Medal";
		}
		if (nums.length >= 2) {
			ret[rank.get(nums[nums.length - 2])] = "Silver Medal";
		}
		if (nums.length >= 1) {
			ret[rank.get(nums[nums.length - 1])] = "Golden Medal";
		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
