package findTheDifference;

public class FindTheDifference {

	public char findTheDifference(String s, String t) {

		int []charsInS=new int [26];
		int []charsInT=new int [26];
		
		for (int i=0;i<26;i++) {
			charsInS[i]=0;
			charsInT[i]=0;
		}
		
		for (int i=0;i<s.length();i++) {
			charsInS[s.charAt(i)-'a']++;
		}
		
		for (int i=0;i<t.length();i++) {
			charsInT[t.charAt(i)-'a']++;
		}
		
		for (int i=0;i<26;i++) {
			if (charsInT[i]-charsInS[i]==1) {
				return (char)(i+'a');
			}
		}
		
		return 'a';
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
