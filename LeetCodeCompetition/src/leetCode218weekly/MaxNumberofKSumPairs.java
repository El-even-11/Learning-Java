package leetCode218weekly;

import java.util.HashMap;

public class MaxNumberofKSumPairs {

	public static int maxOperations(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int cnt = 0;
		for (int i : nums) {
			if (map.containsKey(i) && map.get(i) != 0 && map.containsKey(k - i) && map.get(k - i) != 0) {
				if (i == k - i && map.get(i) == 1) {
					continue;
				}
				cnt++;
				map.put(i, map.get(i) - 1);
				map.put(k - i, map.get(k - i) - 1);
			}
		}

		return cnt;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,2,2,3,1,1,4,1 };
		System.out.println(maxOperations(nums, 4));
	}

}
