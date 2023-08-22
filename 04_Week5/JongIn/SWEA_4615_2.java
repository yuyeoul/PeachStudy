package SWEA_4615_재미있는오셀로게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Test Case

		for (int t = 1; t <= T; t++) { // Test Case
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수

			int[][] board = new int[N][N]; // 보드판 배열

			// 방향 : 상 하 좌 우, 대각선(상좌, 상우, 하좌, 하우)
			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

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

			for (int m = 0; m < M; m++) { // M 입력값만큼 반복하기
				int r = sc.nextInt(); // r 위치 (i 위치이고, i = r-1)
				int c = sc.nextInt(); // c 위치 (j 위치이고, j = c-1)
				int stone = sc.nextInt(); // 흑돌(1), 백돌(2) 입력받기
				board[r - 1][c - 1] = stone;

				boolean flag = false; // 한번 더 검색할 때 백돌이나 흑돌이 있는지 여부 확인, 기본값 false

				// 8방향에 대해서 검색
				for (int d = 0; d < 8; d++) {

					int nr = r + dr[d]; // 다음 검색 위치
					int nc = c + dc[d]; // 다음 검색 위치

					if (nr-1 >= 0 && nr-1 < N && nc-1 >= 0 && nc-1 < N && board[r - 1][c - 1] == 1) { // 다음 검색 위치가 범위 안에 있고 기존 입력값이 흑돌일 때
						if (board[nr - 1][nc - 1] == 2) { // 흑돌의 다음 위치 중에 백돌이 있는 경우
							int count = 0;
							while (nr-1 >= 0 && nr-1 < N && nc-1 >= 0 && nc-1 < N) { // 또한 다음 위치의 배열 내 범위 중에서 
								if (board[nr - 1][nc - 1] == 1) { // 같은 방향에서 반복할 때마다 다음 위치에 다시 흑돌이 올 경우
									count++;
									nr = r + dr[d];
									nc = c + dc[d];
									flag = true; // flag를 true로 바꿔준다.
									break;
								} // flag를 바꿔주는 if문 끝
							} // 반복검색하는 while문 끝

							if (flag) { // 만약 flag가 참이라면
								int idx = 0;
								while (idx < count) { // 반복한 count내에서
									board[nr - 1][nc - 1] = 1; // 해당 백돌을 흑돌로 바꿔준다.
									nr = r + dr[d];
									nc = c + dc[d];
									idx++;
								} 
							} // flag가 참일 때 백돌을 흑돌로 바꿔주는 if문 끝
						} // 흑돌 다음 위치에 백돌이 있는 경우 반복문 끝
						
						// 반복문이 끝나면 현재 위치를 다음 위치로 바꿔준다.
						r = nr;
						c = nc;

					} // 다음 검색 위치가 범위 안에 있고 기존 입력값이 흑돌일 때 반복문 끝
					
					else if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[r - 1][c - 1] == 2) { // 다음 검색 위치가 범위 안에 있고 기존 입력값이 백돌일 때
						if (board[nr - 1][nc - 1] == 1) { // 백돌의 다음 위치 중에 흑돌이 있는 경우
							int count = 0;
							while (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 또한 다음 위치의 배열 내 범위 중에서 
								if (board[nr - 1][nc - 1] == 2) { // 같은 방향에서 반복할 때마다 다음 위치에 다시 백돌이 올 경우
									count++;
									nr = r + dr[d];
									nc = c + dc[d];
									flag = true; // flag를 true로 바꿔준다.
									break;
								} // flag를 바꿔주는 if문 끝
							} // 반복검색하는 while문 끝

							if (flag) { // 만약 flag가 참이라면
								int idx = 0;
								while (idx < count) { // 반복한 count내에서
									board[nr - 1][nc - 1] = 2; // 해당 흑돌을 백돌로 바꿔준다.
									nr = r + dr[d]; // 다음위치 증가
									nc = c + dc[d];
									idx++; // 반복횟수 증가
								} 
							} // flag가 참일 때 백돌을 흑돌로 바꿔주는 if문 끝
						} // 흑돌 다음 위치에 백돌이 있는 경우 반복문 끝

					} // 다음 검색 위치가 범위 안에 있고 기존 입력값이 흑돌일 때 반복문 끝
					
					// 반복문이 끝나면 현재 위치를 다음 위치로 바꿔준다.
					r = nr;
					c = nc;

				} // 8방향 검색 완료

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