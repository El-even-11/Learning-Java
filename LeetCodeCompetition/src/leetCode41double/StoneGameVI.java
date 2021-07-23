package leetCode41double;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class StoneGameVI {
	public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
		int n = aliceValues.length;
		// HashMap<Integer, Integer> alice = new HashMap<>();
		// HashMap<Integer, Integer> bob = new HashMap<>();

		HashMap<Integer, Queue<Integer>> aver = new HashMap<>();
		int[] ave = new int[n];
		boolean[] exist = new boolean[n];
		for (int i = 0; i < n; i++) {
			int a = aliceValues[i];
			int b = bobValues[i];
			ave[i] = Math.abs(a - b);
			// alice.put(aliceValues[i], i);
			// bob.put(bobValues[i], i);
			Queue<Integer> temp = aver.getOrDefault(ave[i], new LinkedList<>());
			temp.offer(i);
			aver.put(ave[i], temp);
			exist[i] = true;
		}

		Arrays.sort(ave);

		int ascore = 0;
		int bscore = 0;
		boolean aliceturn = true;
		int aindex = n - 1;
		int bindex = n - 1;
		int cnt = 0;
		while (cnt < n) {
			if (aliceturn) {
				while (aindex >= 0 && !exist[aver.get(ave[aindex]).peek()]) {
					aindex--;
				}
				if (aindex >= 0) {
					ascore += aliceValues[aver.get(ave[aindex]).peek()];
					exist[aver.get(ave[aindex]).peek()] = false;
					if (aver.get(ave[aindex]).size() > 1) {
						aver.get(ave[aindex]).poll();
					}
					cnt++;
					aliceturn = false;
				}
			} else {
				while (bindex >= 0 && !exist[aver.get(ave[bindex]).peek()]) {
					bindex--;
				}
				if (bindex >= 0) {
					bscore += bobValues[aver.get(ave[bindex]).peek()];
					exist[aver.get(ave[bindex]).peek()] = false;
					if (aver.get(ave[aindex]).size() > 1) {
						aver.get(ave[aindex]).poll();
					}
					cnt++;
					aliceturn = true;
				}
			}
		}

		if (ascore > bscore) {
			return 1;
		} else if (ascore == bscore) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 9, 8, 3, 8 };
		int[] b = { 10, 6, 9, 5 };

		System.out.println(stoneGameVI(a, b));
	}

}
