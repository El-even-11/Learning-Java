package leetCode43double;

public class CalculateMoneyinLeetcodeBank {

	public int totalMoney(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			if ((i - 1) % 7 == 0) {
				dp[i] = dp[i - 7] + 1;
			} else {
				dp[i] = dp[i - 1] + 1;
			}
			sum+=dp[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
