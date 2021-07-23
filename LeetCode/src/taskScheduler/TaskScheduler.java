package taskScheduler;

import java.util.Arrays;

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {

		int[] cnt = new int[26];

		for (int i = 0; i < tasks.length; i++) {
			cnt[tasks[i] - 'A']++;
		}

		Arrays.sort(cnt);

		int maxCnt = 0;

		for (int i = 25; i >= 0; i--) {
			if (cnt[i] == cnt[25]) {
				maxCnt++;
			}
		}

		return Math.max((cnt[25] - 1) * (n + 1) + maxCnt, tasks.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		System.out.println(leastInterval(tasks, 2));
	}

}
