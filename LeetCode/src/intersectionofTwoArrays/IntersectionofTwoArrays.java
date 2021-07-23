package intersectionofTwoArrays;

import java.util.HashSet;

public class IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> numsOne=new HashSet<>();
		HashSet<Integer> numsTwo=new HashSet<>();
		HashSet<Integer> intersection=new HashSet<>();
		
		for (int i:nums1) {
			numsOne.add(i);
		}
		
		for (int i:nums2) {
			numsTwo.add(i);
		}
		
		for (int i:numsOne) {
			if (numsTwo.contains(i)) {
				intersection.add(i);
			}
		}
		
		int []ans=new int [intersection.size()];
		int cnt=0;
		for (int i:intersection) {
			ans[cnt]=i;
			cnt++;
		}
		return ans;
	}
	
	public int[] intersectionTwo(int[] nums1, int[] nums2) {
		HashSet<Integer> numsOne=new HashSet<>();
		HashSet<Integer> intersection=new HashSet<>();
		
		for (int i:nums1) {
			numsOne.add(i);
		}
		
		for (int i:nums2) {
			if (numsOne.contains(i)) {
				intersection.add(i);
			}
		}
		
		int []ans=new int [intersection.size()];
		int cnt=0;
		for (int i:intersection) {
			ans[cnt]=i;
			cnt++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
