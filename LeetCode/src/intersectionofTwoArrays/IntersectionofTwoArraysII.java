package intersectionofTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoArraysII {

	public static int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> nums = new HashMap<>();
		ArrayList<Integer> ret = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			nums.put(nums1[i], nums.getOrDefault(nums1[i], 0) + 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (nums.containsKey(nums2[i]) && nums.get(nums2[i]) != 0) {
				ret.add(nums2[i]);
				nums.put(nums2[i], nums.get(nums2[i]) - 1);
			}
		}

		int ans[] = new int[ret.size()];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = ret.get(i);
		}

		return ans;
	}
	
	public static void main(String[] args) {
		int a[]= {1,2,3,3,4};
		int b[]= {2,3,4,4,5};
		
		int []ans=intersect(a, b);
		
	}
}
