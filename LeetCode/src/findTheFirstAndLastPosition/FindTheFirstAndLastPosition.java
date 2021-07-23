package findTheFirstAndLastPosition;

public class FindTheFirstAndLastPosition {

	public static int[] searchRange(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums.length == 0) {
			return ret;
		}

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = high + (low - high) / 2;

			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				int first = mid;
				int last = mid;
				while (first >= 0 && nums[first] == target) {
					first--;
				}
				ret[0] = first + 1;
				while (last < nums.length && nums[last] == target) {
					last++;
				}
				ret[1] = last - 1;
				break;
			}
		}

		return ret;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1 };
		searchRange(nums, 1);
	}

}
