package scoreAfterFlippingMatrix;

public class ScoreAfterFlippingMatrix {

	public static int matrixScore(int[][] A) {

		if (A[0].length == 1) {
			return A.length;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 0) {
				for (int j = 0; j < A[i].length; j++) {
					if (A[i][j] == 0) {
						A[i][j] = 1;
					} else {
						A[i][j] = 0;
					}
				}
			}
		}

		for (int j = 1; j < A[0].length; j++) {
			int totalOne = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i][j] == 1) {
					totalOne++;
				}
			}
			if (totalOne <= A.length / 2) {
				for (int i=0;i<A.length;i++) {
					if (A[i][j] == 0) {
						A[i][j] = 1;
					} else {
						A[i][j] = 0;
					}
				}
			}
		}
		
		int ret=0;
		
		for (int i=0;i<A.length;i++) {
			for (int j=A[0].length-1;j>=0;j--) {
				ret+=A[i][j]*Math.pow(2,A[0].length-j-1);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]A= {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		System.out.println(matrixScore(A));
	}

}
