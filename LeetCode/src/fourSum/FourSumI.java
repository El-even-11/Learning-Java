package fourSum;

import java.util.ArrayList;
import java.util.List;

public class FourSumI {

	public static List<List<Integer>> ret = new ArrayList<>();

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		kSolved(0, new ArrayList<Integer>(), nums, target);

		return ret;
	}

	public static void kSolved(int start, List<Integer> prob, int[] nums, int target) {

		List<Integer> now = new ArrayList<>();

		for (Integer i : prob) {
			now.add(i);
		}

		if (now.size() == 4) {
			int sum = 0;
			for (Integer i : now) {
				sum += i;
			}
			if (sum == target) {
				ret.add(now);
				return;
			}
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (now.size()<3) {
				now.add(nums[i]);
			}
			
			if (now.size()==3) {
				int sum = 0;
				for (Integer n : now) {
					sum += n;
				}
				sum+=nums[i];
				if (sum==target) {
					now.add(nums[i]);
				}
			}
			kSolved(start + 1, now, nums, target);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,0,-1,0,-2,2};
		fourSum(nums,0);
	}

}
