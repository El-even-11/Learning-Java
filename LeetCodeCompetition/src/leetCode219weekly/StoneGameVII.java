package leetCode219weekly;

import java.util.ArrayList;

public class StoneGameVII {

	public static int stoneGameVII(int[] stones) {

		int sum = 0;
		int n = stones.length;
		ArrayList<Integer> stone = new ArrayList<>();
		for (int i : stones) {
			sum += i;
			stone.add(i);
		}
		int a = 0;
		int b = 0;

		int cnt = 0;
		boolean aturn = true;
		while (cnt < n) {
			if (aturn) {
				if (stone.get(0) > stone.get(stone.size() - 1)) {
					sum -= stone.get(stone.size() - 1);
					a += sum;
					stone.remove(stone.size() - 1);
				} else {
					sum -= stone.get(0);
					a += sum;
					stone.remove(0);
				}
				aturn = false;
				cnt++;
			} else {
				if (stone.size() < 2) {
					break;
				}
				int[] l = new int[stone.size() - 1];
				for (int i = 1; i < stone.size(); i++) {
					l[i - 1] = stone.get(i);
				}

				int[] r = new int[stone.size() - 1];

				for (int i = 0; i < stone.size() - 1; i++) {
					r[i] = stone.get(i);
				}

				int left = stoneGameVII(l);
				int right = stoneGameVII(r);

				if (left < right) {
					sum -= stone.get(0);
					b += sum;
					stone.remove(0);
				} else {
					sum -= stone.get(stone.size() - 1);
					b += sum;
					stone.remove(stone.size() - 1);
				}

				aturn = true;
				cnt++;
			}
		}

		return a - b;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 721, 979, 690, 84, 742, 873, 31, 323, 819, 22, 928, 866, 118, 843, 169, 818, 908, 832, 852, 480,
				763, 715, 875, 629 };
		System.out.println(stoneGameVII(n));
	}

}
