package uniquePaths;

public class UniquePaths {

	static int[][] dp;

	public static int uniquePaths(int m, int n) {
		dp = new int[m + 1][n + 1];
		dp[1][1]=1;
		return dp(m, n);
	}

	public static int dp(int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		dp[i][j] = dp(i - 1, j) + dp(i, j - 1);
		return dp[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3, 7));
	}

}
