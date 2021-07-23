package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		
		for (int i = 0; i <= rowIndex; i++) {
			ret.add(0);
		}

		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i; j >=0; j--) {
				if (j == 0 || j == i) {
					ret.set(j, 1);
				} else {
					ret.set(j, ret.get(j - 1) + ret.get(j));
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		getRow(3);
	}
}
