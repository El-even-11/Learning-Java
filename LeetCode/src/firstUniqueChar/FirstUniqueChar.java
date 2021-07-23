package firstUniqueChar;

public class FirstUniqueChar {

	public static int firstUniqChar(String s) {

		int []indexes=new int [26];
		
		for (int i=0;i<26;i++) {
			indexes[i]=-1;
		}
		
		for (int i=0;i<s.length();i++) {
			char now=s.charAt(i);
			if (indexes[(int)(now-'a')]==-1) {
				indexes[(int)(now-'a')]=i;
			}
		}
		
		int []cnt=new int [26];
		
		for (int i=0;i<26;i++) {
			cnt[i]=0;
		}
		
		for (int i=0;i<s.length();i++) {
			char now=s.charAt(i);
			cnt[(int)(now-'a')]++;
		}
		
		int minIndex=s.length()-1;
		for (int i=0;i<26;i++) {
			if (cnt[i]==1) {
				if (indexes[i]<minIndex) {
					minIndex=indexes[i];
				}
			}
		}
		
		return minIndex;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("loveleetcode"));
	}

}
