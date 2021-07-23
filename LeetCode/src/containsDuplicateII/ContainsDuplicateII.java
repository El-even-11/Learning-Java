package containsDuplicateII;

import java.util.HashMap;

public class ContainsDuplicateII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> existKey = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (existKey.get(nums[i]) == null) {
				existKey.put(nums[i], i);
			} else {
				if (k>=(i-existKey.get(nums[i]))) {
					return true;
				}else {
					existKey.put(nums[i], i);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,1,2,3};
		System.out.println(containsNearbyDuplicate(nums,2));
	}

}
