package BOJ_14502_연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, maxSafeArea;
	static int[][] map;
	static boolean[][] visited;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N, M : 지도의 세로 및 가로 크기 (3 ≤ N, M ≤ 8)
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		// map 데이터 입력받기 (0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 끝

		maxSafeArea = 0;

		setWall(0);
		System.out.println(maxSafeArea);

	} // main

	// 벽 3개를 세우는 경우의 수를 만드는 메서드
	public static void setWall(int wallCount) {
		// 기저 조건
		if (wallCount == 3) {
			// 벽이 3개인 경우에 대해 BFS 탐색
			BFS();
			return;
		}

		// 재귀 조건
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 빈 칸인 경우에만 벽을 세울 수 있음
				if (map[i][j] == 0) {
					// 벽을 세우고, 다음 위치에서 재귀 호출, 원래 상태로 복구
					map[i][j] = 1;
					setWall(wallCount + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	// 바이러스 탐색 메서드
	public static void BFS() {

		// 맵 복사
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		Queue<int[]> q = new LinkedList<>();
		// 바이러스 위치 찾아서 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 빈 공간인 경우에만 바이러스 확산 가능
					if (tempMap[nr][nc] == 0) {
						tempMap[nr][nc] = 2;
						q.offer(new int[] { nr, nc });

					}

				}
			} // 4방탐색 끝

		} // while문 끝

		// 안전 영역 크기 계산 및 최대값 갱신
		int safeArea = countSafeArea(tempMap);
		maxSafeArea = Math.max(maxSafeArea, safeArea);

	} // BFS 끝

	// 안전 영역 크기 계산 메서드
	private static int countSafeArea(int[][] arr) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

} // class