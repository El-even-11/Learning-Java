package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>> ret = new ArrayList<>();
	static List<Integer> a = new ArrayList<>();
	static long sum = 0;

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);

		backtrack(0, candidates, target);
		return ret;
	}

	public static void backtrack(int k, int[] candidates, int target) {

		if (sum == target) {
			List<Integer> ans=new ArrayList<>(a);
			ret.add(ans);
			return;
		}

		for (int i = 0; i + k < candidates.length; i++) {

			sum += candidates[i + k];
			if (sum > target) {
				sum -= candidates[i + k];
				break;
			}

			a.add(candidates[i + k]);
			backtrack(i + k, candidates, target);
			a.remove(a.size() - 1);
			sum -= candidates[i + k];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 2, 3, 5 };
		combinationSum(candidates, 8);
	}

}
