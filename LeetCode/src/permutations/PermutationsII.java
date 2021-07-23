package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

	static HashSet<List<Integer>> ret = new HashSet<>();
	static List<Integer> a = new ArrayList<>();
	static boolean[] used;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		used=new boolean[nums.length];

		backtrack(0, nums);

		List<List<Integer>> ans=new ArrayList<>();
		for (List<Integer> i : ret) {
			ans.add(i);
		}
		
		return ans;
	}

	public static void backtrack(int k, int[] nums) {
		if (k == nums.length) {

			ret.add(new ArrayList<>(a));

			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]==true) {
				continue;
			}
			a.add(nums[i]);
			used[i]=true;

			backtrack(k + 1, nums);

			a.remove(a.size() - 1);
			used[i]=false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,1,2 };
		permuteUnique(nums);
	}

}
