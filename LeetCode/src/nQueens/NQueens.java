package nQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	int N;
	List<List<String>> solves = new ArrayList<>();
	int[] queenPos = new int[100];

	public List<List<String>> solveNQueens(int n) {
		N = n;

		KQueens(0);

		return solves;
	}

	public void KQueens(int k) {
		if (k == N) {
			List<String> solveNow = new ArrayList<>();
			for (int i=0;i<N;i++) {
				StringBuilder now=new StringBuilder();
				for (int j=0;j<N;j++) {
					if (queenPos[j]==i) {
						now.append('Q');
					}
					else {
						now.append('.');
					}
				}
				solveNow.add(now.toString());
			}
			
			solves.add(solveNow);
			return;
		}

		for (int i = 0; i < N; i++) {
			int j;
			for (j = 0; j < k; j++) {
				if (queenPos[j] == i || Math.abs(i - queenPos[j]) == k - j) {
					break;
				}
			}
			if (j==k) {
				queenPos[k]=i;
				KQueens(k+1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens test=new NQueens();
		test.solveNQueens(4);
	}

}
