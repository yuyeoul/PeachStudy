package SWEA_4615_재미있는오셀로게임;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Test Case

		for (int t = 1; t <= T; t++) { // Test Case
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수

			int[][] board = new int[N][N]; // 보드판 배열

			// 중앙 배치
//			board[N / 2 - 1][N / 2 - 1] = 2; // 백
//			board[N / 2 - 1][N / 2] = 1; // 흑
//			board[N / 2][N / 2 - 1] = 1; // 흑
//			board[N / 2][N / 2] = 2; // 백

			// 흑돌(B): 1 , 백돌(W): 2
			// 배열은 0,0부터 시작하는데 주어지는 입력값은 1,1부터 시작한다!!
			for (int i = N / 2 - 1; i <= N / 2; i++) { // 중앙에 2개의 흑돌, 백돌 위치 정해주기
				for (int j = N / 2 - 1; j <= N / 2; j++) {
					if (i == j) {
						board[i][j] = 2;
					} else {
						board[i][j] = 1;
					}
				}

			} // 중앙 흑돌, 백돌 배치 반복문 끝

			// M번만큼만 반복문 실행
			for (int m = 0; m < M; m++) {
				int r = sc.nextInt() - 1; // 숫자에 비해 배열값은 1씩 크기 때문에 바로 빼준다.
				int c = sc.nextInt() - 1;
				int stone = sc.nextInt(); // 놓을 돌의 색
				board[r][c] = stone; // 돌 놓기

				// 상 하 좌 우, 대각선(상좌, 상우, 하좌, 하우)
				int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
				int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

				// 8방향 확인하기
				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d]; // 다음 탐색할 방향을 가르키는 좌표
					int nc = c + dc[d];

					// 다음 탐색할 방향이 범위 내에 있고 보드판이 0이 아닌 경우에
					while (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != 0) {
						if (board[nr][nc] == stone) { // 다음 위치에 오는 돌이, 현재 내 돌과 같은 색인 경우
							while (nr != r || nc != c) { // nr과 nc가 초기 위치(r,c)가 될때까지 반복
								nr -= dr[d]; // 이전 위치로 되돌아가기
								nc -= dc[d];
								board[nr][nc] = stone; // 돌을 뒤집어서 현재 플레이어의 돌로 바꿔주기
							}
							break; // 다 뒤집은 후에는 이제 더 이상 탐색할 필요 없어.
						} // 돌 바꾸기 if문 끝

						// 다음 탐색한 위치가 나랑 같은 색의 돌이 아니면 다시 다음 위치로 이동
						// 한쪽 방향에 대해 돌을 다 바꾸었을 때 다른쪽 방향도 봐야함.
						nr += dr[d];
						nc += dc[d];
					} // while문 끝
				}
			}

			int blackCount = 0;
			int whiteCount = 0;

			// 흑돌, 백돌 갯수 세어주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						blackCount++;
					} else if (board[i][j] == 2) {
						whiteCount++;
					}
				}
			}

			System.out.println("#" + t + " " + blackCount + " " + whiteCount);
		}
	}
}