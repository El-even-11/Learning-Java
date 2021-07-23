package watering;

import java.util.Scanner;

public class Watering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] flower = new int[n + 1];
		int[][] water = new int[m][2];
		for (int i = 0; i < m; i++) {
			water[i][0] = in.nextInt();
			water[i][1] = in.nextInt();
		}

		for (int i = 0; i < m; i++) {
			for (int j = water[i][0]; j <= water[i][1]; j++) {
				flower[j]++;
			}
		}
		
		for (int i=1;i<=n;i++) {
			if (flower[i]!=1) {
				System.out.print(i+" "+flower[i]);
				return;
			}
		}
		
		System.out.print("OK");
		in.close();
	}

}
