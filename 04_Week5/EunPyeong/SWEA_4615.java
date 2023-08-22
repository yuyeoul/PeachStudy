import java.util.Scanner;

public class SWEA_4615 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 바둑판 크기
			int N = sc.nextInt();
			// 바둑알 놓는 횟수
			int M = sc.nextInt();
			// 바둑판
			int[][] playGround = new int[N][N];
			// 정가운데 바둑돌 배치
			// 흰돌
			playGround[N / 2 - 1][N / 2 - 1] = 2;
			playGround[N / 2][N / 2] = 2;
			// 검은돌
			playGround[N / 2 - 1][N / 2] = 1;
			playGround[N / 2][N / 2 - 1] = 1;
			for (int i = 0; i < M; i++) {
				// 행
				int c = sc.nextInt() - 1;
				// 열
				int r = sc.nextInt() - 1;
				// 바둑돌 색깔
				int stone = sc.nextInt();

				// 해당 자리에 바둑돌 놓기
				playGround[r][c] = stone;

				// 8방향 이동을 위한 배열 생성
				int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
				int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

				for (int j = 0; j < 8; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					// 이동한 위치가 범위를 벗어난다면

					// 다음번에 나와 같은 돌이 나오는지 판단하기 위해 변수 선언
					boolean flag = false;
					// 몇번 바꾸어주어야 할지 판단
					int cnt = 0;
					// 범위체크 및 0이 아닌 경우에만 반복
					while (nr < N && nr >= 0 && nc < N && nc >= 0 && playGround[nr][nc] != 0) {
						// 현재 돌 색깔과 다른 경우
						if (playGround[nr][nc] != stone) {
							cnt++;
							nr += dr[j];
							nc += dc[j];
							// 같은 색의 돌을 만난 경우
						} else if (playGround[nr][nc] == stone) {
							flag = true;
							break;
						}
					}
					// 색깔 변화주기
					if (flag) {
						for (int k = cnt; k > 0; k--) {
							nr -= dr[j];
							nc -= dc[j];
							playGround[nr][nc] = stone;
						}
					}

				}
			}
			int black = 0;
			int white = 0;
			for (int i = 0; i < playGround.length; i++) {
				for (int j = 0; j < playGround[i].length; j++) {
					if (playGround[i][j] == 1) {
						black++;
					} else if(playGround[i][j]==2) {
						white++;
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, black, white);
		}
	}
}
