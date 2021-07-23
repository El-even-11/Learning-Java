package createMaximumNumber;

import java.util.Stack;

public class CreateMaximumNumber {

	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

		int m = nums1.length;
		int n = nums2.length;

		int start = Math.max(0, k - n);
		int end = Math.min(k, m);

		int[] ret = new int[k];

		for (int i = start; i <= end; i++) {
			int[] sub1 = maxSubsequence(nums1, i);
			int[] sub2 = maxSubsequence(nums2, k - i);

			int[] cur = merge(sub1, sub2);

			if (compare(cur, ret, 0, 0) > 0) {
				System.arraycopy(cur, 0, ret, 0, k);
			}
		}

		return ret;
	}

	public static int[] maxSubsequence(int[] nums, int k) { // 取k个数字，使子串最大

		Stack<Integer> stack = new Stack<>();
		int remainPop = nums.length - k;

		for (int i = 0; i < nums.length; i++) {
			while (remainPop > 0 && !stack.isEmpty() && nums[i] > stack.peek()) {
				stack.pop();
				remainPop--;
			}

			stack.push(nums[i]);
		}

		Stack<Integer> ret = new Stack<>();

		while (!stack.isEmpty()) {
			ret.push(stack.pop());
		}

		int[] ans = new int[k];

		for (int i = 0; i < k; i++) {
			ans[i] = ret.pop();
		}

		return ans;
	}

	public static int[] merge(int[] sub1, int[] sub2) {

		if (sub1.length == 0) {
			return sub2;
		}

		if (sub2.length == 0) {
			return sub1;
		}

		int i = 0;
		int j = 0;
		int pos = 0;
		int m = sub1.length;
		int n = sub2.length;
		int[] ret = new int[m + n];

		while (i < m || j < n) {
			if (i >= m) {
				ret[pos++] = sub2[j++];
			} else if (j >= n) {
				ret[pos++] = sub1[i++];
			} else if (compare(sub1, sub2, i, j) > 0) {
				ret[pos++] = sub1[i++];
			} else {
				ret[pos++] = sub2[j++];
			}
		}

		return ret;
	}

	public static int compare(int[] sub1, int[] sub2, int index1, int index2) {

		int m = sub1.length;
		int n = sub2.length;

		while (index1 < m && index2 < n) {
			if (sub1[index1] > sub2[index2]) {
				return 1;
			} else if (sub1[index1] < sub2[index2]) {
				return -1;
			} else {
				index1++;
				index2++;
			}
		}

		if (index1 == m && index2 == n) {
			return 0;
		} else if (index1 == m) {
			return -1;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 5, 2 };
		int[] nums2 = { 5, 6 };
		merge(nums1, nums2);
	}

}
