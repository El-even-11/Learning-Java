package addBinary;

public class AddBinary {

	public static String addBinary(String a, String b) {

		int len = Math.max(a.length(), b.length());

		int[] num1 = new int[len];
		for (int i = len - a.length(); i < len; i++) {
			num1[i] = (int) a.charAt(i - len + a.length()) - (int) '0';
		}

		int[] num2 = new int[len];
		for (int i = len - b.length(); i < len; i++) {
			num2[i] = (int) b.charAt(i - len + b.length()) - (int) '0';
		}

		int[] sum = new int[len];
		for (int i = 0; i < len; i++) {
			sum[i] = num1[i] + num2[i];
		}

		for (int i = len - 1; i > 0; i--) {
			if (sum[i] == 2) {
				sum[i] = 0;
				sum[i - 1]++;
			} else if (sum[i] == 3) {
				sum[i] = 1;
				sum[i - 1]++;
			}
		}

		StringBuffer s_sum = new StringBuffer();
		
		for (int i=0;i<sum.length;i++) {
			s_sum.append((char)(sum[i]+'0'));
		}

		if (s_sum.charAt(0) == '2') {
			s_sum.setCharAt(0, '0');
			s_sum.insert(0, "1");
		}
		if (s_sum.charAt(0) == '3') {
			s_sum.setCharAt(0, '1');
			s_sum.insert(0, "1");
		}

		return s_sum.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(addBinary("1010", "1011"));
//		String s = "abc";
//		StringBuffer sb = new StringBuffer(s);
//
//		if (sb.charAt(0) == 'a') {
//			sb.setCharAt(0, 'b');
//			sb.insert(0, "a");
//		}
//
//		System.out.print(sb);
	}

}
