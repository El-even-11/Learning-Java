package validPalindrome;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		StringBuilder sb =new StringBuilder();
		String s_sovel=s.toLowerCase();
		
		for (int i=0;i<s.length();i++) {
			if (s_sovel.charAt(i)>='a'&&s_sovel.charAt(i)<='z') {
				sb.append(s_sovel.charAt(i));
			}
		}
		
		boolean isPalindrome=true;
		
		for (int i=0;i<sb.length();i++) {
			if (sb.charAt(i)!=sb.charAt(sb.length()-i-1)) {
				isPalindrome=false;
			}
		}
		
		return isPalindrome;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
