package leetCode218weekly;

import java.util.HashMap;

public class MinimumIncompatibility {

	public int minimumIncompatibility(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Integer i : map.keySet()) {
			if (map.get(i) > k) {
				return -1;
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
