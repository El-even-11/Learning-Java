package permutationSequence;

import java.util.Arrays;


public class PermutationSequence {

	static int cnt = 0;
	static String[] ret;
	static StringBuilder a = new StringBuilder();

	public static String getPermutation(int n, int k) {

		ret = new String[f(n)];
		backtrack(0, n, k);

		return ret[k - 1];
	}

	public static int backtrack(int k, int n,int deep) {
		if (k == n) {
			ret[cnt] = a.toString();
			cnt++;
			return cnt;
		}

		for (int i = 1; i <= n; i++) {
			if (a.toString().indexOf((char)(i+'0'))!=-1) {
				continue;
			}
			a.append((char) (i + '0'));

			if(backtrack(k + 1, n,deep)==deep) {
				return cnt;
			}

			a.deleteCharAt(a.length() - 1);
		}
		
		return cnt;
	}

	public static int f(int n) {
		int ans=1;
		while (n>0) {
			ans=ans*n;
			n--;
		}
		return ans;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 3));
	}

}
