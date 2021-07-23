package addStrings;

public class AddStrings {

	public static String addStrings(String num1, String num2) {

		StringBuilder sbnum1 = new StringBuilder(num1);
		StringBuilder sbnum2 = new StringBuilder(num2);

		int maxLen = Math.max(num1.length(), num2.length());
		StringBuilder zeroes = new StringBuilder();

		
		num1.split(" ");
		
		for (int i = 0; i < Math.abs(num1.length() - num2.length()); i++) {
			zeroes.append("0");
		}

		if (num1.length() == maxLen) {
			sbnum2.insert(0, zeroes.toString());
		} else {
			sbnum1.insert(0, zeroes.toString());
		}

		StringBuilder ret = new StringBuilder();

		boolean needCarry = false;
		for (int i = maxLen - 1; i >= 0; i--) {
			int now;
			if (needCarry) {
				now = (sbnum1.charAt(i) - '0') + (sbnum2.charAt(i) - '0')+1;
				if (now<10) {
					needCarry=false;
				}
			}else {
				now = (sbnum1.charAt(i) - '0') + (sbnum2.charAt(i) - '0');
				if (now>=10) {
					needCarry=true;
				}
			}
			
			ret.insert(0,"" + now % 10);

		}

		if (needCarry) {
			ret.insert(0, "1");
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("9", "99"));
	}

}
