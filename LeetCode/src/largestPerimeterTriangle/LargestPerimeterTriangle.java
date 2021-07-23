package largestPerimeterTriangle;

public class LargestPerimeterTriangle {

	public static int largestPerimeter(int[] A) {

		int perimeter = 0;

		for (int lh = 0; lh < A.length; lh++) {
			int max = lh;
			for (int rh = lh + 1; rh < A.length; rh++) {
				if (A[rh] > A[max]) {
					max = rh;
				}
			}
			int temp = A[lh];
			A[lh] = A[max];
			A[max] = temp;
		}

		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] < A[i + 1] + A[i + 2]) {
				perimeter = A[i] + A[i + 1] + A[i + 2];
				return perimeter;
			}
		}

		return perimeter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {3,2,3,4};
		System.out.println(largestPerimeter(A));
	}

}
