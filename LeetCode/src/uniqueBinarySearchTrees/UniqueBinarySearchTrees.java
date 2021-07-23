package uniqueBinarySearchTrees;

public class UniqueBinarySearchTrees {

	static int[][] dfs;
	
	public static int numTrees(int n) {
		if (n == 0) {
			return 0;
		}
		
		dfs=new int [n+2][n+2];

		return dfs(1, n);
	}

	public static int dfs(int start, int end) {
		if (dfs[start][end]!=0) {
			return dfs[start][end];
		}
		
		if (start>end) {
			dfs[start][end]=1;
			return 1; 
		}
		
		int sum=0;
		for (int i=start;i<=end;i++) {
			int left;
			if (dfs[start][i-1]==0) {
				dfs[start][i-1]=dfs(start,i-1);
			}
			left=dfs[start][i-1];
			
			int right;
			if (dfs[i+1][end]==0) {
				dfs[i+1][end]=dfs(i+1,end);
			}
			right=dfs[i+1][end];
			
			sum+=left*right;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(7));
	}
}
