package searchInsertPosition;

import java.util.Scanner;

public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
			if (nums[i] > target)
				return i;
		}
		return nums.length;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = in.nextInt();
		}

		int target = in.nextInt();

		System.out.println(searchInsert(nums, target));
	}

}
