package bestTimetoBuyandSellStock;

public class BestTimetoBuyandSellStockIV {

	public int maxProfit(int k, int[] prices) {

		int len = prices.length;
		int dp[][][] = new int[len][k + 1][2];

		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= k; j++) {

				if (i - 1 == -1) {
					dp[0][j][0] = 0;
					dp[0][j][1] = -prices[0];
					continue;
				}
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

			}
		}

		return dp[len-1][k][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
