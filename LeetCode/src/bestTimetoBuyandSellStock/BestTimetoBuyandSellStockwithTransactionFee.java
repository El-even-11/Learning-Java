package bestTimetoBuyandSellStock;

public class BestTimetoBuyandSellStockwithTransactionFee {

	public static int maxProfit(int[] prices, int fee) {

		int[][] dp = new int[prices.length][2];

		for (int i = 0; i < prices.length; i++) {

			if (i - 1 == -1) {
				dp[0][0] = 0;
				dp[0][1] = -prices[0] - fee;
				continue;
			}

			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
		}

		return dp[prices.length - 1][0];
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
