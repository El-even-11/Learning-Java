package summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> intervals = new ArrayList<String>();

		int start = 0;
		int end = nums.length - 1;

		if (nums.length == 1) {
			intervals.add("\"" + nums[0] + "\"");
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] != 1) {
				end = i;
				if (end == start) {
					intervals.add("\"" + nums[start] + "\"");
				} else {
					intervals.add("\"" + nums[start] + "->" + nums[end] + "\"");
				}
				start = i + 1;
			}

			if (i + 1 == nums.length - 1) {
				if (start == i + 1) {
					intervals.add("\"" + nums[start] + "\"");
				} else {
					intervals.add("\"" + nums[start] + "->" + nums[i + 1] + "\"");
				}
			}
		}

		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 0, 1, 2, 4, 5, 7 };
		System.out.println(summaryRanges(nums));
	}

}
