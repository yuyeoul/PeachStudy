import java.util.Scanner;

public class BOJ_9663 {
	public static int[][] chess;
	public static int N;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new int[N][N];
		makeQueen(0);
		System.out.println(ans);
	}

	public static void makeQueen(int i) {
		if (i >= N) {
			ans++;
			return;
		}

		for (int j = 0; j < N; j++) {
			if (chess[i][j] != 0) {
				continue;
			}
			// 현재 위치 +1
			chess[i][j] += 1;
			// 수직 아래 +1
			for (int k = i + 1; k < N; k++) {
				chess[k][j] += 1;
			}
			// 우하향 대각선 +1
			for (int k = i + 1, o = j + 1; k < N && o < N; k++, o++) {
				chess[k][o] += 1;
			}
			// 좌하향 대각선 +1
			for (int k = i + 1, o = j - 1; k < N && o >= 0; k++, o--) {
				chess[k][o] += 1;
			}

			makeQueen(i + 1);

			// 현재 위치 -1
			chess[i][j] -= 1;
			// 수직 아래 -1
			for (int k = i + 1; k < N; k++) {
				chess[k][j] -= 1;
			}
			// 우하향 대각선 -1
			for (int k = i + 1, o = j + 1; k < N && o < N; k++, o++) {
				chess[k][o] -= 1;
			}
			// 좌하향 대각선 -1
			for (int k = i + 1, o = j - 1; k < N && o >= 0; k++, o--) {
				chess[k][o] -= 1;
			}
		}
	}
}