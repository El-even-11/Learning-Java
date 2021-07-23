package grumpyBookstoreOwner;

public class GrumpyBookstoreOwner {

	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

		int ret = 0;
		int[] more = new int[customers.length];
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 1) {
				more[i] = customers[i];
			} else {
				ret += customers[i];
			}
		}

		int max = 0;
		for (int i = 0; i < X; i++) {
			max += more[i];
		}

		int now = max;
		for (int i = 1; i < more.length - X + 1; i++) {
			now = now - more[i - 1] + more[i + X - 1];
			max = Math.max(max, now);
		}

		return ret + max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		System.out.println(maxSatisfied(customers, grumpy, 3));
	}

}
