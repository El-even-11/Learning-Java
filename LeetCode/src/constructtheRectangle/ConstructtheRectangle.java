package constructtheRectangle;

import java.util.ArrayList;

public class ConstructtheRectangle {

	public int[] constructRectangle(int area) {

		int sqrt = (int) Math.sqrt(area);

		int[] ret = new int[2];
		if (sqrt * sqrt == area) {
			ret[0] = sqrt;
			ret[1] = sqrt;
			return ret;
		}
		
		return ret;

	}

	public int[] constructRectangleII(int area) {

		int[] ret = new int[2];
		ArrayList<Integer> factors = new ArrayList<>();

		for (int i = 1; i <= area; i++) {
			if (area % i == 0) {
				factors.add(i);
			}
		}

		if (factors.size() % 2 == 0) {
			ret[0] = factors.get(factors.size() / 2 - 1);
			ret[1] = factors.get(factors.size() / 2);
		} else {

			ret[0] = factors.get(factors.size() / 2);
			ret[1] = ret[0];
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
