package lastStoneWeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

	Comparator<Integer> cmp = new Comparator<Integer>() {
		public int compare(Integer i, Integer j) {
			return j - i;
		}
	};

	public int lastStoneWeight(int[] stones) {

		Queue<Integer> Stones = new PriorityQueue<>(cmp);

		Arrays.sort(stones);
		for (int i : stones) {
			Stones.add(i);
		}

		while (Stones.size() > 1) {
			int p1 = Stones.poll();
			int p2 = Stones.poll();

			if (p1 > p2) {
				Stones.add(p1 - p2);
			}
		}

		if (Stones.size() == 0) {
			return 0;
		}

		return Stones.poll();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
