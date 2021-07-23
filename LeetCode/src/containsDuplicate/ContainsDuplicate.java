package containsDuplicate;

import java.util.HashMap;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {

		HashMap<Integer, Boolean> existKey= new HashMap<>(); 
		
		for (int i=0;i<nums.length;i++) {
			if (existKey.get(nums[i])==null) {
				existKey.put(nums[i],true);
			}else {
				return true;
			}
		}
		
		return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums= {1,2,3,4,5,6,7,8};
		System.out.println(containsDuplicate(nums));
	}

}
