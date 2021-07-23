package excelSheetColumnNumber;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		char[] s1 = s.toCharArray();
		int ans = 0;
		for (int i = 0; i < s1.length; i++) {
			ans = ans * 26 + (int) (s1[i] - 'A' + 1);
		}
		
		int []fac;
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ZY"));
	}

}
