package twoSumII;

public class TwoSumII {

	public static int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		int max_index;

		int left = 0;
		int right = numbers.length - 1;

		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (numbers[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}

		max_index = right;

		// have found the position of answer

		for (int i = 0; i < max_index; i++) {
			int left1 = i + 1;
			int right1 = max_index;
			while (left1 <= right1 ) {
				int mid = (left1 + right1) / 2;
				if (target - numbers[i] < numbers[mid]) {
					right1 = mid-1;
				} else if (target - numbers[i] > numbers[mid]) {
					left1 = mid+1;
				} else {
					ans[0] = i + 1;
					ans[1] = mid + 1;
					return ans;
				}
			}
		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {2,3,4};
		int [] ans=twoSum(nums,6);

		System.out.println(ans[0]+" "+ans[1]);
	}

}
