package BOJ_20058_마법사상어와파이어스톰;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, q, splitSize, N, sum;
	static int[] fire;
	static int[][] icePlate;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n : 얼음판의 크기 (2 ≤ n ≤ 6), q : 파이어스톰 시전 횟수
		n = sc.nextInt();
		q = sc.nextInt();
		fire = new int[q];
		// N = 2의 n 제곱
		N = (int) Math.pow(2, n);
		icePlate = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				icePlate[i][j] = sc.nextInt();
			}
		} // 얼음판 입력 끝

		// 파이어스톰 시전한 단계 입력
		for (int i = 0; i < q; i++) {
			// L : 파이어 스톰의 단계
			int L = sc.nextInt();
			fire[i] = (int) Math.pow(2, L);
		} // 파이어스톰 시전한 단계 입력 끝

		// 파이어스톰 횟수만큼 반복
		for (int i = 0; i < q; i++) {
			// splitSize = 2의 L승만큼 크기로 분할
			splitSize = fire[i];
			split(0, 0, N);

		} // 파이어스톰 반복 끝
		
		// 얼음 크기검사
		check();
		// iceCnt : 얼음덩어리의 수
		int iceCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && icePlate[i][j] != 0) {
					iceCnt++;
					BFS(i, j);

				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(icePlate[i]));
		}
		
		System.out.println(sum);
		System.out.println(iceCnt);
	} // main

	// 격자를 나누는 메서드 (fire[i]의 크기에 맞게 4분할)
	public static void split(int r, int c, int size) {
		// 기저 조건
		// size == fire[i]번째라면
		if (size == splitSize) {
			// 회전, 탐색
			rotate(r, c);
//			BFS();
			return;
		}
		// 재귀 조건
		split(r, c, size / 2);
		split(r, c + size / 2, size / 2);
		split(r + size / 2, c, size / 2);
		split(r + size / 2, c + size / 2, size / 2);

	}

	// 나눈 격자를 시계방향으로 회전시키는 메서드
	public static void rotate(int r, int c) {
		// 정사각행렬이므로 arr, rotate 배열의 크기는 동일

		int[][] rotate = new int[splitSize][splitSize];

		for (int i = 0; i < splitSize; i++) {
			for (int j = 0; j < splitSize; j++) {
				rotate[i][j] = icePlate[r + splitSize - 1 - j][c + i];
			}
		}

		// 회전한 rotate 배열을 icePlate에 다시 전환
		for (int i = 0; i < splitSize; i++) {
			for (int j = 0; j < splitSize; j++) {
				icePlate[r + i][c + j] = rotate[i][j];
			}
		}

	}

	// 얼음을 찾는 BFS 또는 DFS 메서드
	public static void BFS(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			sum += icePlate[pos[0]][pos[1]];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && icePlate[nr][nc] != 0) {
					
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}

	} // BFS 끝

	// 해당 위치의 얼음이 줄어드는지 안줄어드는지 판별하는 메서드
	public static void check() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (i == 0 || i == N - 1) {
					cnt++;
				}
				if (j == 0 || j == N - 1) {
					cnt++;
				}
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && icePlate[nr][nc] == 0) {
						cnt++;
					}
				}
				if (cnt >= 2 && icePlate[i][j] > 0) {
					icePlate[i][j]--;
				}
			}
		}
	}

} // class
