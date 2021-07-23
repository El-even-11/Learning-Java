package validAnagram;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		HashMap<Character,Integer> charsCnt=new HashMap<>();
		for (int i=0;i<s.length();i++) {
			charsCnt.put(s.charAt(i), 0);
		}
		
		for (int i=0;i<s.length();i++) {
			charsCnt.put(s.charAt(i), charsCnt.get(s.charAt(i))+1);
		}
		
		for (int i=0;i<t.length();i++) {
			if (charsCnt.get(t.charAt(i))==null) {
				return false;
			}
			charsCnt.put(t.charAt(i), charsCnt.get(t.charAt(i))-1);
		}
		
		for (Character a:charsCnt.keySet()) {
			if (charsCnt.get(a)!=0) {
				return false;
			}
		}
		
		return true;
    }
	
	public static boolean isAnagramTwo(String s, String t) {
		char[]sChars=s.toCharArray();
        char[]tChars=t.toCharArray();
		Arrays.sort(sChars);
        Arrays.sort(sChars);

        for (int i=0;i<s.length();i++){
            if (sChars[i]!=tChars[i]){
                return false;
            }
        }
        
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagramTwo("anagram", "nagaram"));
	}

}
