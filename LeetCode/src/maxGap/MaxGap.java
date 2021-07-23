package maxGap;

public class MaxGap {

	public static int maximumGap(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxVal) {
				maxVal = nums[i];
			}

			if (nums[i] < minVal) {
				minVal = nums[i];
			}
		}

		int bucketsSize = Math.max(1, (maxVal - minVal) / (nums.length - 1));

		int bucketsNum = Math.max(1, (maxVal - minVal) / bucketsSize + 1);

		int[][] buckets = new int[bucketsNum][2];

		for (int i = 0; i < bucketsNum; i++) {
			buckets[i][0] = -1;
			buckets[i][1] = -1;
		}

		for (int i = 0; i < nums.length; i++) {
			int bucketIndex = (nums[i] - minVal) / bucketsSize;
			if (buckets[bucketIndex][0] == -1 && buckets[bucketIndex][1] == -1) {
				buckets[bucketIndex][0] = nums[i];
				buckets[bucketIndex][1] = nums[i];
			} else {
				if (nums[i] > buckets[bucketIndex][1]) {
					buckets[bucketIndex][1] = nums[i];
				}

				if (nums[i] < buckets[bucketIndex][0]) {
					buckets[bucketIndex][0] = nums[i];
				}
			}
		}
		int maxGap = 0;

		int min;
		int max;
		int i = 0;
		while (i < bucketsNum) {

			while (buckets[i][0] == -1 && buckets[i][1] == -1 && i < bucketsNum - 1) {
				i++;
			}

			max = buckets[i][1];

			i++;

			if (i < bucketsNum) {
				while (buckets[i][0] == -1 && buckets[i][1] == -1 && i < bucketsNum - 1) {
					i++;
				}
				min = buckets[i][0];
				if (min - max > maxGap) {
					maxGap = min - max;
				}
			}

		}
		return maxGap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 23909, 19622, 13107, 10834, 11667, 28450, 30959, 7877, 6015, 4816, 17362, 3482, 2247, 230, 16899,
				3818, 4461, 16494, 31033, 290, 1918, 15188, 10109, 30387, 3570, 14782, 8496, 11275, 724, 10139, 20559,
				6597, 6307, 22655, 14582, 30492, 7927, 15790, 10019, 16550, 15975, 17015, 27069, 5951, 11179, 17091,
				16085, 2882, 5630, 20461, 21803, 10240, 21702, 14292, 1780, 21354, 6263, 559, 12762, 22033, 8885, 22561,
				20549, 8017, 18873, 2574, 14297, 6600, 19189, 10156, 8512, 9229, 12539, 24157, 23849, 415, 20635, 4540,
				23184, 22556, 8523 };
		System.out.print(maximumGap(a));

	}

}
