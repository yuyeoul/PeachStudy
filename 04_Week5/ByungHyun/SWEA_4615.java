import java.util.Scanner;

public class SWEA_4615 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 받기
		int TEST = sc.nextInt();

		// 방향 백터
		// 동 서 남 북 대각선
		int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

		for (int testCase = 1; testCase <= TEST; testCase++) {
			// 보드판 크기 n
			int n = sc.nextInt();
			// 돌을 놓는 횟수 m
			int m = sc.nextInt();

			// 보드판 생성 n *n
			char[][] board = new char[n][n];
			
			// 결과값을 저장할 변수
			int countB = 0; // 흑돌의 개수
			int countW = 0; // 백돌의 개수

			// 초기 흑, 백돌 생성
			board[(n / 2) - 1][(n / 2) - 1] = 'W';
			board[(n / 2)][(n / 2)] = 'W';
			board[(n / 2)][(n / 2) - 1] = 'B';
			board[(n / 2) - 1][(n / 2)] = 'B';

			// 돌을 놓는 for문
			for (int num = 0; num < m; num++) {
				int x = sc.nextInt() - 1; // y 위치
				int y = sc.nextInt() - 1; // x 위치
				int wb = sc.nextInt(); // 흰돌인지 검은돌인지 1이면 흑돌, 2이면 백돌
				int nx = 0;
				int ny = 0;

				if (wb == 1) {
					board[x][y] = 'B';
					// 돌이 흑돌일때
					for (int index = 0; index < 8; index++) {
						// 8가지 방향으로 탐색
						nx = x + dx[index];
						ny = y + dy[index];

						// 돌을 바꿀지 말지 판단하는 변수
						boolean r = false;

						// 주위의 돌이 흰색이면 탐색 시작
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 'W') {
							while (true) {
								// 새로운 위치 탐색
								// 만약 위치가 범위가 보드를 넘어가거나 위치에 아무것도 없으면 r을 false
								// 만약 탐색했는데 새로운 위치의 값이 검은색이면 r을 true로 바꾸고 while문을 빠져나간다.
								nx += dx[index];
								ny += dy[index];

								// 새로운 위치가 보드에 벗어나면 while문을 break;
								if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
									break;
								}

								// 새로운 위치의 값이 공백이면 break;
								if (board[nx][ny] == 0) {
									break;
								}

								// 새로운 위치의 값이 B이면 r을 true로 만들고 break;
								if (board[nx][ny] == 'B') {
									r = true;
									// B가 있으면 해당위치를 원래 위치에서 이동한 위치로 초기화
									nx = x + dx[index];
									ny = y + dy[index];
									break;
								}
							}
						}
						
						// r이 true면 돌을 바꿔야하므로 돌바꾸기
						if (r) {
							while (true) {
								// 해당 자리 B로 만들기
								board[nx][ny] = 'B';

								nx += dx[index];
								ny += dy[index];

								// 다음 자리가 B이면 멈추기
								if (board[nx][ny] == 'B') {
									break;
								}
							}
						}
					}
				} else {
					board[x][y] = 'W';
					// 돌이 백돌일때
					for (int index = 0; index < 8; index++) {
						// 8가지 방향으로 탐색
						nx = x + dx[index];
						ny = y + dy[index];

						// 돌을 바꿀지 말지 판단하는 변수
						boolean r = false;

						// 주위의 돌이 흑색이면 탐색 시작
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 'B') {
							while (true) {
								// 새로운 위치 탐색
								// 만약 위치가 범위가 보드를 넘어가거나 위치에 아무것도 없으면 r을 false
								// 만약 탐색했는데 새로운 위치의 값이 검은색이면 r을 true로 바꾸고 while문을 빠져나간다.
								nx += dx[index];
								ny += dy[index];

								// 새로운 위치가 보드에 벗어나면 while문을 break;
								if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
									break;
								}

								// 새로운 위치의 값이 공백이면 break;
								if (board[nx][ny] == 0) {
									break;
								}

								// 새로운 위치의 값이 B이면 r을 true로 만들고 break;
								if (board[nx][ny] == 'W') {
									r = true;
									// W가 있으면 해당위치를 원래 위치에서 이동한 위치로 초기화
									nx = x + dx[index];
									ny = y + dy[index];
									break;
								}
							}
						}

						// r이 true면 돌을 바꿔야하므로 돌바꾸기
						if (r) {
							while (true) {
								// 해당위치를 W로 바꾸기
								board[nx][ny] = 'W';

								nx += dx[index];
								ny += dy[index];

								// 다음위치의 값이 W면 멈추기
								if (board[nx][ny] == 'W') {
									break;
								}
							}
						}
					}
				}
				
			}
			
			// 보드에서의 흰색 돌의 개수와 검은색 돌의 개수 세기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'W') {
						countW++;
					} else if (board[i][j] == 'B') {
						countB++;
					}
				}
			}
			
			// 결과 출력
			System.out.println("#" + testCase + " " + countB + " " + countW);
		}
	}
}
