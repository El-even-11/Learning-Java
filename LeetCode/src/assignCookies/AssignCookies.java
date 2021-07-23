package assignCookies;

import java.util.Arrays;

public class AssignCookies {

	public static int findContentChildren(int[] g, int[] s) {

		int cnt = 0;

		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0;
		int j=0;
		
		while (i < g.length && j < s.length) {
			if (s[j]>=g[i]) {
				cnt++;
				i++;
			}
			j++;
		}
		
		return cnt;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []g= {1,2,3};
		int []s= {1,3};
		System.out.println(findContentChildren(g, s));
	}

}
