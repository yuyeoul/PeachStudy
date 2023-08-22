package SWEA_4615_재미있는오셀로게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Test Case

		for (int t = 1; t <= T; t++) { // Test Case
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수

			int[][] board = new int[N][N]; // 보드판 배열

			// 방향 : 상 하 좌 우
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int dir = 0; // 방향

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

//			 중앙 흑돌, 백돌 배치 잘 되어있는지 확인
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(board[i][j]);
//                }
//                System.out.println();
//            }

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt(); // x 위치 (i 위치이고, i = x-1)
				int y = sc.nextInt(); // y 위치 (j 위치이고, j = y-1)
				int stone = sc.nextInt(); // 흑돌(1), 백돌(2) 입력받기
				board[x - 1][y - 1] = stone;

				if (x - 1 > 0 && y - 1 > 0 && x - 1 < N && y - 1 < N && board[x - 1][y - 1] == 1) { // 범위 안에서 흑돌을 넣었을 경우
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (세로 위)
					if (x - 3 >= 0 && x - 2 >= 0 && board[x - 2][y - 1] == 2 && board[x - 3][y - 1] == 1) {
						board[x - 2][y - 1] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (세로 아래)
					if (x + 1 < N && x < N && board[x][y - 1] == 2 && board[x + 1][y - 1] == 1) {
						board[x][y - 1] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (가로 왼쪽)
					if (y - 3 > 0 && y - 2 > 0 && board[x - 1][y - 2] == 2 && board[x - 1][y - 3] == 1) {
						board[x - 1][y - 2] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (가로 오른쪽)
					if (y < N && y + 1 < N && board[x - 1][y] == 2 && board[x - 1][y + 1] == 1) {
						board[x - 1][y] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (대각선 좌측 위)
					if (x - 3 >= 0 && x - 2 >= 0 && y - 3 >= 0 && y - 2 >= 0 && board[x - 2][y - 2] == 2
							&& board[x - 3][y - 3] == 1) {
						board[x - 2][y - 2] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (대각선 우측 위)
					if (x - 3 >= 0 && x - 2 >= 0 && y < N && y + 1 < N && board[x - 2][y] == 2
							&& board[x - 3][y + 1] == 1) {
						board[x - 2][y] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (대각선 좌측 아래)
					if (x < N && x + 1 < N && y - 3 >= 0 && y - 2 >= 0 && board[x][y - 2] == 2
							&& board[x + 1][y - 3] == 1) {
						board[x][y - 2] = 1;
					}
					// 흑돌을 넣었을 때 사이에 백돌이 있는 경우 (대각선 우측 아래)
					if (x < N && x + 1 < N && y < N && y + 1 < N && board[x][y] == 2 && board[x + 1][y + 1] == 1) {
						board[x][y - 2] = 1;
					}

				} // 흑돌 안에서 입력받았을 경우 끝

				// 백돌
				if (x - 1 > 0 && y - 1 > 0 && x - 1 < N && y - 1 < N && board[x - 1][y - 1] == 2) { // 범위 안에서 백돌을 넣었을 경우
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (세로 위)
					if (x - 3 >= 0 && x - 2 >= 0 && board[x - 2][y - 1] == 1 && board[x - 3][y - 1] == 1) {
						board[x - 2][y - 1] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (세로 아래)
					if (x + 1 < N && x < N && board[x][y - 1] == 1 && board[x + 1][y - 1] == 2) {
						board[x][y - 1] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (가로 왼쪽)
					if (y - 3 > 0 && y - 2 > 0 && board[x - 1][y - 2] == 1 && board[x - 1][y - 3] == 2) {
						board[x - 1][y - 2] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (가로 오른쪽)
					if (y < N && y + 1 < N && board[x - 1][y] == 1 && board[x - 1][y + 1] == 2) {
						board[x - 1][y] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (대각선 좌측 위)
					if (x - 3 >= 0 && x - 2 >= 0 && y - 3 >= 0 && y - 2 >= 0 && board[x - 2][y - 2] == 1
							&& board[x - 3][y - 3] == 2) {
						board[x - 2][y - 2] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (대각선 우측 위)
					if (x - 3 >= 0 && x - 2 >= 0 && y < N && y + 1 < N && board[x - 2][y] == 1
							&& board[x - 3][y + 1] == 2) {
						board[x - 2][y] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (대각선 좌측 아래)
					if (x < N && x + 1 < N && y - 3 >= 0 && y - 2 >= 0 && board[x][y - 2] == 1
							&& board[x + 1][y - 3] == 2) {
						board[x][y - 2] = 2;
					}
					// 백돌을 넣었을 때 사이에 흑돌이 있는 경우 (대각선 우측 아래)
					if (x < N && x + 1 < N && y < N && y + 1 < N && board[x][y] == 1 && board[x + 1][y + 1] == 2) {
						board[x][y - 2] = 2;
					}

				} // 백돌 안에서 입력받았을 경우 끝

			} // M만큼 입력받는 것 끝

			// 넣는 값 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}

		} // Test Case 끝

	} // main 끝

} // class 끝