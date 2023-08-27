import java.util.Scanner;

class SWEA_5215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int ingredient = sc.nextInt();
			int limit = sc.nextInt();
			int[][] dp = new int[ingredient + 1][limit + 1];
			for (int i = 1; i < dp.length; i++) {
				int taste = sc.nextInt();
				int weight = sc.nextInt();
				for (int j = 1; j < dp[i].length; j++) {
					if (weight <= j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + taste);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			System.out.printf("#%d %d\n", tc, dp[ingredient][limit]);
		}
	}
}