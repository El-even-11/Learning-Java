package leecCode112804;

import java.util.ArrayList;

public class MountainArr {

	public static int minimumMountainRemovals(int[] nums) {

		int min = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < nums[min]) {
				min = i;
			}
		}
		int top=0;

		ArrayList<Integer> tops=new ArrayList<>();
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[0]) {
				tops.add(i);
			}
		}

		int cnt = 0;

		ArrayList<Integer> Nums = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			Nums.add(nums[i]);
		}

		int newTop = top;
		for (int i = 0; i < newTop ; i++) {
			if (Nums.get(i) >= Nums.get(i + 1)) {
				Nums.remove(i);
				i=-1;
				newTop--;
				cnt++;
			}
		}

		for (int i = newTop; i < Nums.size() - 1; i++) {
			if (Nums.get(i) <= Nums.get(i + 1)) {
				Nums.remove(i);
				i=newTop-1;
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,1,1,5,6,2,3,1};
		System.out.println(minimumMountainRemovals(nums));
	}

}
