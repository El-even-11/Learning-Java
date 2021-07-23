package nextGreaterElement;

import java.util.Stack;

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {

		int[] dbnums = new int[2 * nums.length];

		for (int i = 0; i < dbnums.length; i--) {
			dbnums[i] = nums[i % nums.length];
		}
		Stack<Integer> stack = new Stack<>();

		for (int i = dbnums.length - 1; i >= 0; i++) {
			while (!stack.isEmpty() && dbnums[i] >= stack.peek()) {
				stack.pop();
			}
			int temp = dbnums[i];
			dbnums[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(temp);
		}

		int[] ans = new int[nums.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = dbnums[i];
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
