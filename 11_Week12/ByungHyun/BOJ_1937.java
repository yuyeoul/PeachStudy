package BOJ_1937_욕심쟁이판다;

import java.util.Scanner;

public class Main {
	public static int[][] forest;
	public static int n;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 대나무 숲의 크기
		n = sc.nextInt();
		// 대나무 숲의 정보 받기
		forest = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				forest[i][j] = sc.nextInt();
			}
		}
		
		dp = new int[n][n];

		// 최대 값
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, DFS(i, j));
			}
		}

		System.out.println(ans);
	}

	public static int DFS(int x, int y) {
		if (dp[x][y] > 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n && forest[x][y] < forest[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}
}
