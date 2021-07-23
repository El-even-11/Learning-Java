package leetCode41double;

import java.util.HashSet;

public class CounttheNumberofConsistentStrings {
	public static int countConsistentStrings(String allowed, String[] words) {
		HashSet<Character> chars=new HashSet<>();
		for (Character i:allowed.toCharArray()) {
			chars.add(i);
		}
		
		int cnt=0;
		
		boolean contains=true;
		for (int i=0;i<words.length;i++) {
			for (Character k:words[i].toCharArray()) {
				if (!chars.contains(k)) {
					contains=false;
					break;
				}
			}
			if (contains) {
				cnt++;
			}
			contains=true;
		}
		
		return cnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
