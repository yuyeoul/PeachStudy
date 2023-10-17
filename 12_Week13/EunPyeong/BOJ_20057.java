import java.io.IOException;
import java.util.Scanner;

public class BOJ_20057 {
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { -1, 0, 1, 0 };
	public static int N;
	public static int[][] map;
	// 모래가 날아가는 방향 첫번째[]: 4방향 두번째[]: %별로 구분(1,2,5,7,10,a 순서) 세번째[]: %별 갯수만큼
	public static int[][][] tdr = { { { -1, 1 }, { -2, 2 }, { 0 }, { -1, 1 }, { -1, 1 }, { 0 } },
			{ { -1, -1 }, { 0, 0 }, { 2 }, { 0, 0 }, { 1, 1 }, { 1 } },
			{ { -1, 1 }, { 2, -2 }, { 0 }, { -1, 1 }, { -1, 1 }, { 0 } },
			{ { 1, 1 }, { 0, 0 }, { -2 }, { 0, 0 }, { -1, -1 }, { -1 } } };
	public static int[][][] tdc = { { { 1, 1 }, { 0, 0 }, { -2 }, { 0, 0 }, { -1, -1 }, { -1 } },
			{ { -1, 1 }, { -2, 2 }, { 0 }, { -1, 1 }, { -1, 1 }, { 0 } },
			{ { -1, -1 }, { 0, 0 }, { 2 }, { 0, 0 }, { 1, 1 }, { 1 } },
			{ { -1, 1 }, { -2, 2 }, { 0 }, { -1, 1 }, { -1, 1 }, { 0 } } };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 격자 크기
		N = sc.nextInt();
		// 격자 배열
		map = new int[N][N];
		// 최초 모래양
		int originalSand = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				originalSand += map[i][j];
			}
		}
		// 시작지점의 행,열
		int str = N / 2, stc = N / 2;

		rotate(str, stc);

		// 최종 모래양
		int finalSand = 0;
		// 최종 모래양 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				finalSand += map[i][j];
			}
		}
		// 차이 출력
		System.out.println(originalSand - finalSand);
	}

	// 도는 매서드
	public static void rotate(int str, int stc) {
		int nr = str;
		int nc = stc;
		int cnt = 1;
		int dirChange = 0;
		while (cnt < N) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < cnt; j++) {
					// 방향 조절 변수가 4이상이 될 때 4로 나눈 나머지를 이용하기
					if (dirChange >= 4)
						dirChange %= 4;
					// 이동한 위치
					nr += dr[dirChange];
					nc += dc[dirChange];
					// 토네이도 매서드
					tornado(nr, nc, dirChange);
				}
				// 방향 전환해주기
				dirChange++;
			}
			cnt++;
		}

		// 나머지 한바퀴 더
		for (int i = 0; i < cnt - 1; i++) {
			if (dirChange >= 4)
				dirChange %= 4;
			nr += dr[dirChange];
			nc += dc[dirChange];
			tornado(nr, nc, dirChange);
		}
	}

	// 토네이도 매서드(모래 날리기)
	public static void tornado(int nr, int nc, int dirChange) {
		// 이동하기 전의 위치 (모래양 구하려고)
		double sand = map[nr][nc];
		int r = 0;
		int c = 0;

		double movedSand = 0;
		// 1%
		for (int i = 0; i < 2; i++) {
			r = nr + tdr[dirChange][0][i];
			c = nc + tdc[dirChange][0][i];
			movedSand += Math.floor(sand * 0.01);
			if (r < 0 || c < 0 || r >= N || c >= N) {
				continue;
			}
			map[r][c] += Math.floor(sand * 0.01);
		}
		// 2%
		for (int i = 0; i < 2; i++) {
			r = nr + tdr[dirChange][1][i];
			c = nc + tdc[dirChange][1][i];
			movedSand += Math.floor(sand * 0.02);
			if (r < 0 || c < 0 || r >= N || c >= N) {
				continue;
			}
			map[r][c] += Math.floor(sand * 0.02);
		}

		// 5%
		for (int i = 0; i < 1; i++) {
			r = nr + tdr[dirChange][2][i];
			c = nc + tdc[dirChange][2][i];
			movedSand += Math.floor(sand * 0.05);
			if (r < 0 || c < 0 || r >= N || c >= N) {
				continue;
			}
			map[r][c] += Math.floor(sand * 0.05);
		}

		// 7%
		for (int i = 0; i < 2; i++) {
			r = nr + tdr[dirChange][3][i];
			c = nc + tdc[dirChange][3][i];
			movedSand += Math.floor(sand * 0.07);
			if (r < 0 || c < 0 || r >= N || c >= N) {
				continue;
			}
			map[r][c] += Math.floor(sand * 0.07);
		}

		// 10%
		for (int i = 0; i < 2; i++) {
			r = nr + tdr[dirChange][4][i];
			c = nc + tdc[dirChange][4][i];
			movedSand += Math.floor(sand * 0.1);
			if (r < 0 || c < 0 || r >= N || c >= N) {
				continue;
			}
			map[r][c] += Math.floor(sand * 0.1);
		}
		// a 구역
		r = nr + tdr[dirChange][5][0];
		c = nc + tdc[dirChange][5][0];
		if (r >= 0 && c >= 0 && r < N && c < N) {
			map[r][c] += Math.floor(sand - movedSand);
		}

		map[nr][nc] = 0;
	}
}
