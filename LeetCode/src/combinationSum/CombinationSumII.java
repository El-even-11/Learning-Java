package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

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
			List<Integer> ans = new ArrayList<>(a);

			boolean isExist = false;
			for (List<Integer> i : ret) {
				if (i.equals(ans)) {
					isExist = true;
				}
			}
			if (!isExist) {
				ret.add(ans);
			}
			return;
		}

		for (int i = k; i < candidates.length; i++) {

			sum += candidates[i];
			if (sum > target) {
				sum -= candidates[i];
				break;
			}

			a.add(candidates[i]);
			backtrack(i + 1, candidates, target);
			a.remove(a.size() - 1);
			sum -= candidates[i];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		combinationSum(candidates, 8);
		
		System.out.println();
	}

}
