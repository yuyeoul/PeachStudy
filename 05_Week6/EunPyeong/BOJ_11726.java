import java.util.Scanner;

public class BOJ_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력값
		int N = sc.nextInt();
		// dp 이용하기 위한 배열 선언
		int[][] memo = new int[N + 1][N / 2 + 2];

		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo.length; j++) {
				if (j == 1) {
					memo[i][j] = 1;
				} else if (i > 1 && j == 2) {
					memo[i][j] = (i - 1) % 10007;
				} else if (i / 2 + 1 >= j) {
					memo[i][j] = (memo[i - 1][j] + memo[i - 2][j - 1]) % 10007;
				}
			}
		}
		// 해당 행 합 구하기
		int ans = 0;

		for (int j = 1; j < memo[N].length; j++) {
			ans += memo[N][j];
		}
		System.out.println(ans % 10007);
	}
}