package bestTimetoBuyandSellStock;

public class BestTimetoBuyandSellStockwithCooldown {

	public int maxProfit(int[] prices) {

		int len = prices.length;

		if (len == 0) {
			return 0;
		}

		int[][] dp = new int[len][2];

		for (int i = 0; i < len; i++) {
			if (i - 1 == -1) {
				dp[0][0] = 0;
				dp[0][1] = -prices[i];

				continue;
			}

			if (i - 2 == -1) {
				dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
				dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

				continue;
			}

			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
		}

		return dp[len - 1][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
