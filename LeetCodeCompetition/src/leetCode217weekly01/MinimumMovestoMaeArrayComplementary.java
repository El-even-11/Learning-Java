package leetCode217weekly01;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumMovestoMaeArrayComplementary {

	public static int minMoves(int[] nums, int limit) {
		HashMap<Integer, Integer> sums = new HashMap<>();

		int len = nums.length;
		for (int i = 0; i < nums.length / 2; i++) {
			int sum = nums[i] + nums[len - i - 1];
			sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		}

		int max = 0;

		ArrayList<Integer> maxKeys = new ArrayList<>();

		for (Integer i : sums.keySet()) {
			if (sums.get(i) >= max) {
				max = sums.get(i);
				maxKeys.add(i);
			}
		}

		int mincnt = Integer.MAX_VALUE;

		for (Integer maxKey : maxKeys) {

			int cnt = 0;
			for (int i = 0; i < nums.length / 2; i++) {
				int sum = nums[i] + nums[len - i - 1];

				if (sum == maxKey) {
					continue;
				}

				if (Math.min(nums[i], nums[len - i - 1]) >= maxKey) {
					cnt += 2;
				} else if (Math.max(nums[i], nums[len - i - 1]) + limit < maxKey) {
					cnt += 2;
				} else {
					cnt++;
				}

			}
			if (cnt < mincnt) {
				mincnt = cnt;
			}
		}
		return mincnt;
	}

	public static void main(String[] args) {
		int nums[] = { 42, 49, 29, 16, 10, 39, 21, 32, 22, 20, 45, 27, 45, 53, 3, 21, 31, 10, 49, 41, 15, 6, 13, 13, 45,
				10, 9, 12, 37, 47, 44, 29, 32, 48, 13, 11, 52, 43, 53, 13, 2, 32, 27, 22, 45, 7, 35, 19, 47, 10, 28, 6,
				46, 4, 40, 19, 19, 45, 25, 10 };
		System.out.println(minMoves(nums, 53));

	}

}
