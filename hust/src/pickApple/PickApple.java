package pickApple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PickApple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int s = in.nextInt();
		int reach = in.nextInt() + in.nextInt();

		ArrayList<Integer> strengths = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int height = in.nextInt();
			int strength = in.nextInt();
			if (height <= reach) {
				strengths.add(strength);
			}
		}

		Integer[] Strengths = strengths.toArray(new Integer[strengths.size()]);
		Arrays.sort(Strengths);
		int cnt = 0;
		while (s >= 0 && cnt < n) {
			s -= Strengths[cnt];
			if (s >= 0) {
				cnt++;
			}
		}
		System.out.print(cnt);
		in.close();
	}

}
