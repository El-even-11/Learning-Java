package isSubsequence;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {

		Queue<Character> charsInS=new LinkedList<>();
		
		for (int i=0;i<s.length();i++) {
			charsInS.offer(s.charAt(i));
		}
		
		for (int i=0;i<t.length();i++) {
			if (charsInS.peek()==t.charAt(i)) {
				charsInS.poll();
			}
		}
		
		return charsInS.isEmpty();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
