package leetCode219weekly;

public class CountofMatchesinTournament {

	public static int numberOfMatches(int n) {
		return dfs(n);
	}

	public static int dfs(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}

		if (n % 2 == 0) {
			return n / 2 + dfs(n / 2);
		}

		return (n - 1) / 2 + dfs((n - 1) / 2 + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfMatches(7));
	}

}
