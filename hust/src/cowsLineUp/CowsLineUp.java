package cowsLineUp;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CowsLineUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			queue.offer(in.nextInt());
		}

		int pre = queue.poll();
		int now;
		int cnt = 0;

		while (!queue.isEmpty()) {
			now = queue.poll();
			if (now > pre) {
				cnt++;
			}
			pre = now;
		}

		System.out.print(cnt == 0 ? 0 : cnt + 1);
		in.close();
	}

}
