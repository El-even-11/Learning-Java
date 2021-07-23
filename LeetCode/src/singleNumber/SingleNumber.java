package singleNumber;

import java.util.Arrays;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int ans=0;
		for (int i=1;i<nums.length;i+=2) {
			if (nums[i]!=nums[i-1]) {
				ans=nums[i-1];
			}
		}
		
		
		return ans;
    }
	
	
}
