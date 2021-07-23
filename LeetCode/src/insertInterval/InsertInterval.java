package insertInterval;

import java.util.ArrayList;

public class InsertInterval {

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		ArrayList<Integer> all = new ArrayList<>();
		ArrayList<Integer> newNums = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
				all.add(j);
			}
		}

		for (int i = newInterval[0]; i <= newInterval[1]; i++) {
			newNums.add(i);
		}

		int low = 0;
		int high = all.size() - 1;
		boolean found = false;
		while (low < high) {
			int mid = (low + high) / 2;
			if (newNums.get(0) > all.get(mid)) {
				low = mid + 1;
			} else if (newNums.get(0) < all.get(mid)) {
				high = mid - 1;
			} else {
				low = mid;
				high = mid;
				found = true;
			}
		}
		int begin = 0;
		if (found) {
			begin = high;
		} else {
			begin = high + 1;
		}

		// System.out.println(start);

		all.removeAll(newNums);
		all.addAll(begin, newNums);

		ArrayList<int[]> insertedIntevalsList = new ArrayList<>();

		int start = 0;
		int end = all.size() - 1;
		for (int i = 0; i < all.size() - 1; i++) {
			if (all.get(i + 1) - all.get(i) != 1) {
				end = i;
				int[] aNewInteval = { all.get(start), all.get(end) };
				insertedIntevalsList.add(aNewInteval);
				start = i + 1;
			}
		}

		int[] aNewInteval = { all.get(start), all.get(all.size() - 1) };
		insertedIntevalsList.add(aNewInteval);

		int[][] insertedIntervals = new int[insertedIntevalsList.size()][2];

		for (int i = 0; i < insertedIntevalsList.size(); i++) {
			insertedIntervals[i] = insertedIntevalsList.get(i);
		}

		return insertedIntervals;
	}

	public static int[][] insert_corrected(int[][] intervals, int[] newInterval) {

		if (intervals.length == 0) {
			int[][] insertedIntervals = new int[1][2];
			insertedIntervals[0] = newInterval;
			return insertedIntervals;
		}

		int[][] gapIntervals = new int[intervals.length + 1][2];
		gapIntervals[0][0] = Integer.MIN_VALUE;
		gapIntervals[0][1] = intervals[0][0];
		gapIntervals[intervals.length][0] = intervals[intervals.length - 1][1];

		for (int i = 1; i < intervals.length; i++) {
			gapIntervals[i][0] = intervals[i - 1][1];
			gapIntervals[i][1] = intervals[i][0];
		}

		if (newInterval[0] > gapIntervals[intervals.length][0]) {
			int[][] insertedIntervals = new int[intervals.length + 1][2];
			for (int i = 0; i < intervals.length; i++) {
				insertedIntervals[i] = intervals[i];
			}
			insertedIntervals[intervals.length] = newInterval;
			return insertedIntervals;
		}

		int[] theNewInterval = new int[2];
		boolean findStartIndex = false;
		boolean findEndIndex = false;
		boolean endIsInGap = false;

		ArrayList<int[]> insertedIntervalsList = new ArrayList<>();

		int now = 0;

		boolean endOutofIndex = false;
		if (newInterval[1] > gapIntervals[intervals.length][0]) {
			findEndIndex = true;
			endOutofIndex = true;
			theNewInterval[1] = newInterval[1];
		}

		for (int i = 0; i <= intervals.length; i++) {

			if (!findStartIndex) {
				if (newInterval[0] > gapIntervals[i][0] && newInterval[0] < gapIntervals[i][1]) {

					findStartIndex = true;
					theNewInterval[0] = newInterval[0];
				}

				if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
					findStartIndex = true;
					theNewInterval[0] = intervals[i][0];
				}
			}

			if (!findEndIndex) {
				if (newInterval[1] > gapIntervals[i][0] && newInterval[1] < gapIntervals[i][1]) {
					findEndIndex = true;
					endIsInGap = true;
					theNewInterval[1] = newInterval[1];
				}

				if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
					findEndIndex = true;
					theNewInterval[1] = intervals[i][1];
				}
			}

			if (!findStartIndex && (!findEndIndex || findEndIndex && endOutofIndex)) {
				insertedIntervalsList.add(intervals[i]);
			}

			if (findStartIndex && findEndIndex) {
				insertedIntervalsList.add(theNewInterval);
				if (endIsInGap) {
					insertedIntervalsList.add(intervals[i]);
				}
				now = i + 1;
				break;
			}
		}

		if (!endOutofIndex) {
			for (int i = now; i < intervals.length; i++) {
				insertedIntervalsList.add(intervals[i]);
			}
		}

		int[][] insertedIntervals = new int[insertedIntervalsList.size()][2];

		for (int i = 0; i < insertedIntervals.length; i++) {
			insertedIntervals[i] = insertedIntervalsList.get(i);
		}

		return insertedIntervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 6 };
		System.out.println(insert_corrected(intervals, newInterval));
	}

}
