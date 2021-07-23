package abc;

import java.util.Arrays;
import java.util.Scanner;

public class ABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = in.nextInt();
		}
		in.nextLine();
		String s = in.nextLine();
		Arrays.sort(a);
		for (int i = 0; i < 3; i++) {
			System.out.print(a[s.charAt(i)-'A']+" ");
		}
		in.close();
	}

}
