package lengthofLastWord;

public class LengthofLastWord {

	public static int lengthOfLastWord(String s) {

		int lastLen = 0;
		boolean isWord = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && isWord) {
				break;
			} else if (s.charAt(i) != ' ') {
				isWord = true;
				lastLen++;
			}
		}

		return lastLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(lengthOfLastWord("hello world "));
	}

}
