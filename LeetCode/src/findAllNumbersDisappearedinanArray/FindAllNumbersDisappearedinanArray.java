package findAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret=new ArrayList<>();
		
		boolean []exist=new boolean [nums.length+1];
		for (int i=1;i<=nums.length;i++) {
			exist[i]=false;
		}
		
		for (int i=0;i<nums.length;i++) {
			exist[nums[i]]=true;
		}
		
		for (int i=1;i<=nums.length;i++) {
			if (!exist[i]) {
				ret.add(i);
			}
		}
		return ret;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
