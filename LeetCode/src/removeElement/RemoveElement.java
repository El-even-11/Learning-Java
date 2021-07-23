package removeElement;

import java.util.Scanner;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int len=nums.length;
		while (i < nums.length) {
			if (nums[i] == val) {
				for (int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length-1]=100000;
				len--;
			} else {
				i++;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = in.nextInt();
		}

		int len = removeElement(nums, 1);
		for (int i=0;i<len;i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
