package nextGreaterElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		ArrayList<Integer> numsin1 = new ArrayList<Integer>();
		ArrayList<Integer> numsin2 = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			numsin1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			numsin2.add(nums2[i]);
		}

		for (int i = 0; i < nums1.length; i++) {
			int j = numsin2.indexOf(nums1[i]) + 1;
			for (; j < nums2.length; j++) {
				if (nums2[j] > nums1[i]) {
					nums1[i] = nums2[j];
					break;
				}
			}
			if (j == nums2.length) {
				nums1[i] = -1;
			}
		}

		return nums1;
	}

	public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				stack.pop();
			}
			map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
			stack.push(nums2[i]);
		}

		int[] ans = new int[nums1.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = map.get(nums1[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
