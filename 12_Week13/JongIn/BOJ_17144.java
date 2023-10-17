package BOJ_17144_미세먼지안녕;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int R, C, t, ans, airUp, airDown;
	static int[][] map;
	// 상 하 좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
		// R*C의 격자판, T: 시간
		R = sc.nextInt();
		C = sc.nextInt();
		t = sc.nextInt();

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					airDown = i;
					airUp = (i - 1);
				}
			}
		} // map 입력 끝

		int time = 0;
		while (time < t) {
			spread();
			rotate();
			time++;
		}

		// 입력받은 map 확인
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		check();
		System.out.println(ans);
	} // main

	private static void spread() {
		int[][] tmpMap = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// tmp : 확산되는 양
				int tmp = map[r][c] / 5;
				int cnt = 0; // 갯수
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 확산하는 것이 다음 위치가 범위 안에 있고 공기청정기가 아니라면
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
						// 확산되는 양을 새로운 맵에 값을 추가해주고 카운트+1
						tmpMap[nr][nc] += tmp;
						cnt++;
					}
				} // 사방탐색 끝
					// 현재 위치의 값에 카운트해준만큼 빼주기 (확산 전달해준 값)
				tmpMap[r][c] += map[r][c] - tmp * cnt;

			}
		}
		// 임시배열을 다시 원본배열로 덮어주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tmpMap[i][j];
			}
		}
	} // 미세먼지 확산 메서드 끝

	public static void rotate() {
		int[][] tmpMap = new int[R][C];
		// 위 공기청정기
		// 반시계방향 윗줄
		for (int j = 1; j < C; j++) {
			tmpMap[0][j - 1] = map[0][j];
		}

		// 반시계방향 왼쪽줄 (공기청정기에 들어가면 정화됨)
		for (int i = 0; i < airUp - 1; i++) {
			tmpMap[i + 1][0] = map[i][0];
			if (tmpMap[i + 1][0] == airUp) {
				tmpMap[i + 1][0] = 0;
			}
		}

		// 반시계방향 아래쪽 줄
		for (int j = 0; j < C - 1; j++) {

			if (map[airUp][j] != -1) {
				tmpMap[airUp][j + 1] = map[airUp][j];
			} else {
				tmpMap[airUp][j] = map[airUp][j];
			}
		}

		// 반시계방향 오른쪽줄
		for (int i = airUp; i > 0; i--) {
			tmpMap[i - 1][C - 1] = map[i][C - 1];
		}

		// 공기청정이 안되는 윗 구역
		for (int i = 1; i < airUp; i++) {
			for (int j = 1; j < C - 1; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		// ---------------
		// 아래 공기청정기
		// 시계방향 윗줄
		for (int j = 0; j < C - 1; j++) {
			if (map[airDown][j] != -1) {
				tmpMap[airDown][j + 1] = map[airDown][j];
			} else {
				tmpMap[airDown][j] = -1;
			}

		}

		// 시계방향 오른쪽줄
		for (int i = airDown; i < R - 1; i++) {
			tmpMap[i + 1][C - 1] = map[i][C - 1];
		}

		// 시계방향 아래쪽 줄
		for (int j = C - 1; j > 0; j--) {
			tmpMap[R - 1][j - 1] = map[R - 1][j];

		}

		// 시계방향 왼쪽줄 (공기청정기에 들어가면 정화됨)
		for (int i = R - 1; i >= airDown; i--) {
			if (map[i][0] != -1) {
				tmpMap[i - 1][0] = map[i][0];
			} else {
				tmpMap[i][0] = -1;
			}
		}

		// 공기청정이 안되는 아랫 구역
		for (

				int i = airDown + 1; i < R - 1; i++) {
			for (int j = 1; j < C - 1; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}

		// 임시배열을 다시 원본배열로 덮어주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tmpMap[i][j];
			}
		}

	} // 공기청정기 작동 메서드 끝

	public static int check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) {
					ans += map[i][j];
				}
			}
		}
		return ans;
	} // 미세먼지 양 검색하는 메서드 끝
} // class
