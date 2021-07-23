package majorityElement;

import java.util.HashMap;

public class MajorityElement {
	public static int majorityElement(int[] nums) {

		HashMap<Integer, Integer> cnt = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			cnt.put(nums[i], 0);
		}

		for (int i = 0; i < nums.length; i++) {
			cnt.replace(nums[i], cnt.get(nums[i]) + 1);
		}

		int ans = 0;
		for (Integer i : cnt.keySet()) {
			if (cnt.get(i) > nums.length / 2) {
				ans = i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 3, 2, 3 };
		System.out.println(majorityElement(nums));

	}

}
