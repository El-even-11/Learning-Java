package permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	static List<List<Integer>> ret = new ArrayList<>();
	static List<Integer> a = new ArrayList<>();

	public static List<List<Integer>> permute(int[] nums) {

		backtrack(0, nums);

		return ret;
	}

	public static void backtrack(int k, int[] nums) {
		if (k == nums.length) {
			ret.add(new ArrayList<>(a));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (a.contains(nums[i])) {
				continue;
			}
			a.add(nums[i]);

			backtrack(k + 1, nums);

			a.remove(a.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3};
		permute(nums);
	}

}
