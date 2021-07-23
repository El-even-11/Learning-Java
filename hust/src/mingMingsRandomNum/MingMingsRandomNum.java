package mingMingsRandomNum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MingMingsRandomNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashSet<Integer> nums = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int temp = in.nextInt();
			nums.add(temp);
		}

		System.out.println(nums.size());

		Integer[] sort = nums.toArray(new Integer[nums.size()]);

		Arrays.sort(sort);

		for (int i = 0; i < sort.length; i++) {
			System.out.print(sort[i] + " ");
		}
		in.close();
	}

}
