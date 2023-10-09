import java.io.*;
import java.util.*;

public class BOJ_20058 {
	static int N, Q, LEN;
	static int[][] map;
	static boolean[][] visit;
	static int sum = 0;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static class Pair {
		int y, x;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 처리
		N = sc.nextInt(); // 격자판 크기의 지수
		Q = sc.nextInt(); // 연산 횟수
		LEN = (int) Math.pow(2, N); // 격자판 크기 계산
		map = new int[LEN][LEN];

		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				map[i][j] = sc.nextInt(); // 격자판의 초기 상태 입력
				sum += map[i][j]; // 얼음의 합 계산
			}
		}

		for (int i = 0; i < Q; i++) {
			int level = sc.nextInt();
			divideArea(level); // 격자를 나누고 회전하는 함수 호출
			reduceIce(); // 얼음 녹이기 함수 호출
		}

		// 결과 출력
		System.out.println(sum); // 남아있는 얼음의 합 출력
		System.out.println(searchBiggestArea()); // 가장 큰 덩어리의 크기 출력
	}

	// level에 따른 회전 구역 정하기
	private static void divideArea(int level) {
		int len = (int) Math.pow(2, level);
		for (int y = 0; y < LEN; y += len) {
			for (int x = 0; x < LEN; x += len) {
				// 정해진 구역 90도 회전
				rotate(y, x, level);
			}
		}
	}

	// 해당 구역 전체를 90도 회전
	private static void rotate(int sY, int sX, int level) {
		int y = sY;
		int x = sX;
		List<Integer> temp;
		int len = (int) Math.pow(2, level);
		// 해당구역의 안쪽까지 90도 회전을 위해 len을 2씩 감소, len이 2이상인 동안 지속
		while (len >= 2) {
			temp = new ArrayList<>();
			int j = x;
			int i = y + len - 1;
			for (int _i = y; _i < y + len - 1; _i++)
				temp.add(map[_i][x]);
			for (int _i = y; _i < y + len - 1; _i++)
				map[_i][x] = map[y + len - 1][j++];
			for (int _j = x; _j < x + len - 1; _j++)
				map[y + len - 1][_j] = map[i--][x + len - 1];
			for (int _i = y + len - 1; _i >= y; _i--)
				map[_i][x + len - 1] = map[y][j--];
			int idx = 0;
			for (int _j = x + len - 1; _j > x; _j--)
				map[y][_j] = temp.get(idx++);
			y++;
			x++;
			len -= 2;
		}
	}

	// 가장 큰 덩어리를 탐색
	private static int searchBiggestArea() {
		int max = 0;
		visit = new boolean[LEN][LEN];
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				if (map[i][j] == 0 || visit[i][j])
					continue;
				// 해당 위치에서의 덩어리 크기를 탐색(bfs)
				int size = bfs(i, j);
				// 이전까지의 최대 덩어리 크기와 비교/갱신
				max = Math.max(size, max);
			}
		}
		return max;
	}

	// 해당 위치의 덩어리 크기 탐색
	private static int bfs(int i, int j) {
		int size = 0;
		visit[i][j] = true;
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));

		while (!q.isEmpty()) {
			Pair now = q.poll();
			int y = now.y;
			int x = now.x;
			size++;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (!isRange(ny, nx))
					continue;
				if (visit[ny][nx] || map[ny][nx] == 0)
					continue;
				visit[ny][nx] = true;
				q.add(new Pair(ny, nx));
			}
		}
		return size;
	}

	// 얼음 녹이기
	private static void reduceIce() {
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				if (map[i][j] == 0)
					continue;
				// 해당 위치 얼음이 녹는지 확인
				if (isReduce(i, j)) {
					sum--;
					// 한번에 녹이기 위함
					// 녹는 얼음에 대한 좌표 List에 추가
					list.add(new Pair(i, j));
				}
			}
		}
		// List에 담긴 위치의 얼음을 감소
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i).y][list.get(i).x]--;
		}
	}

	// 해당 위치에 얼음이 녹는지 확인
	private static boolean isReduce(int i, int j) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if (!isRange(ny, nx))
				continue;
			if (map[ny][nx] > 0)
				cnt++;
		}
		// 인근 얼음의 개수가 3 이상이면 얼음이 안녹음 -> false
		if (cnt >= 3)
			return false;
		// 이외에는 얼음이 녹음 -> true
		else
			return true;
	}

	// 현재 위치가 정상 범위인지 확인
	private static boolean isRange(int i, int j) {
		if (i < 0 || j < 0 || i >= LEN || j >= LEN)
			return false;
		else
			return true;
	}

}