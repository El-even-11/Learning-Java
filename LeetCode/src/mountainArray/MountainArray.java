package mountainArray;

public class MountainArray {

	public static boolean validMountainArray(int[] A) {

		if (A.length < 3) {
			return false;
		}

		int top = 0;
		int i = 0;
		boolean getTop = false;
		while (!getTop && i < A.length) {
			if (A[i + 1] > A[i]) {
				top = i + 1;
			} else if (A[i + 1] == A[i]) {
				return false;
			} else {
				getTop = true;
			}
			i++;
		}

		if (top == 0 || top == A.length - 1) {
			return false;
		}

		boolean isValidMountainArray = true;
		for (int j = top; j < A.length - 1; j++) {
			if (A[j + 1] >= A[j]) {
				isValidMountainArray = false;
			}
		}

		return isValidMountainArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0, 1, 3, 3, 2, 1 };
		System.out.println(validMountainArray(A));
	}

}
