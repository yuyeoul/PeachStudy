import java.util.Scanner;

public class BOJ_17144 {
	public static int R;
	public static int C;
	public static int T;
	public static int[][] map;
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int[][] airCleanerLocation = new int[2][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자 행
		R = sc.nextInt();
		// 격자 열
		C = sc.nextInt();
		// 초
		T = sc.nextInt();
		// 격자
		map = new int[R][C];
		// 격자 값 할당
		for (int i = 0, idx = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				// 공기청정기 위치 입력
				if (map[i][j] == -1) {
					airCleanerLocation[idx][0] = i;
					airCleanerLocation[idx++][1] = j;
				}
			}
		}
		// T초간의 움직임 변화
		for (int i = 0; i < T; i++) {
			// 미세먼지 위치 이동(dustMovement)
			dustMovement();
			// 공기청정기 바람
			airCleaner();
		}
		// 정답 담을 변수
		int ans = 0;
		// 모두 더해주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
		// 공기청정기 만큼 더한 값 출력해주기
		System.out.println(ans + 2);

	}
	// 먼지 움직이는 메서드
	public static void dustMovement() {
		// 임시로 담을 변수
		int[][] tmp = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 확산된 횟수 담는 변수
				int moveCnt = 0;
				// 한번에 확산되는 양
				int moveDust = map[i][j] / 5;
				// 4방향 탐색
				for (int k = 0; k < 4; k++) {
					// 새로운 행/열
					int nr = i + dr[k];
					int nc = j + dc[k];
					// 범위 체크 및 공기청정기 체크(범위 벗어나거나 공기청정기 만나면 넘어가기)
					if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1)
						continue;
					// 4방향 중 확산횟수 체크
					moveCnt++;
					// 확산가능한 곳은 확산되는 양만큼 더해주기
					tmp[nr][nc] += moveDust;

				}
				tmp[i][j] += (map[i][j] - moveDust * moveCnt);
			}
		}
		map = tmp;
		
	}
	// 공기청정기 작동하는 메서드
	public static void airCleaner() {
		// 임시로 담을 변수
		int[][] tmp = new int[R][C];
		// 위 공기청정기 하 방향
		for (int i = 1; i <= airCleanerLocation[0][0]; i++) {
			// 공기청정기 위치에는 -1 할당
			if (i == airCleanerLocation[0][0]) {
				tmp[i][0] = -1;
				continue;
			}
			tmp[i][0] = map[i - 1][0];
		}
		// 위 공기청정기 우 방향
		for (int j = 1; j < C; j++) {
			// 공기청정기에서 막 나온 공기
			if (j == 1) {
				tmp[airCleanerLocation[0][0]][j] = 0;
				continue;
			}
			tmp[airCleanerLocation[0][0]][j] = map[airCleanerLocation[0][0]][j - 1];
		}
		// 위 공기청정기 상 방향
		for (int i = airCleanerLocation[0][0] - 1; i >= 0; i--) {
			tmp[i][C - 1] = map[i + 1][C - 1];
		}
		// 위 공기청정기 좌 방향
		for (int j = C - 2; j >= 0; j--) {
			tmp[0][j] = map[0][j + 1];
		}

		// 아래 공기청정기 상 방향
		for (int i = R - 2; i >= airCleanerLocation[1][0]; i--) {
			// 공기청정기 위치에는 -1 할당
			if (i == airCleanerLocation[1][0]) {
				tmp[i][0] = -1;
				continue;
			}
			tmp[i][0] = map[i + 1][0];
		}
		// 아래 공기청정기 우 방향
		for (int j = 1; j < C; j++) {
			// 공기청정기에서 막 나온 공기
			if (j == 1) {
				tmp[airCleanerLocation[1][0]][j] = 0;
				continue;
			}
			tmp[airCleanerLocation[1][0]][j] = map[airCleanerLocation[1][0]][j - 1];
		}
		// 아래 공기청정기 하 방향
		for (int i = airCleanerLocation[1][0] + 1; i < R; i++) {
			tmp[i][C - 1] = map[i - 1][C - 1];
		}
		// 아래 공기청정기 좌 방향
		for (int j = C - 2; j >= 0; j--) {
			tmp[R - 1][j] = map[R - 1][j + 1];
		}

		// map 배열에 변화가 있는 부분만 값 재할당해주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R - 1 || i == airCleanerLocation[0][0] || i == airCleanerLocation[1][0] || j == 0
						|| j == C - 1)
					map[i][j] = tmp[i][j];
			}
		}
	}
}