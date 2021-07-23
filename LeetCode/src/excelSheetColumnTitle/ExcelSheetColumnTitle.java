package excelSheetColumnTitle;

import java.util.HashMap;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		HashMap<Integer, String> name = new HashMap<Integer, String>();
		name.put(-1, "");
		
		for (int i = 0; i < 26; i++) {
			name.put(i, ""+(char) (i + 'A'));
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append(name.get(n % 26));
			n /= 26;
		}

		sb.reverse();

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
