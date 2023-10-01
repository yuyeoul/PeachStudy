import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1261 {
	// 정답 : 벽을 뚫는 횟수
	public static int min = Integer.MAX_VALUE;
	// 4방향 탐색을 위한 변수
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	// 가로 세로 크기
	public static int N, M;
	// 방문 체크 위한 변수
	public static boolean[][] visited;
	// 미로 담기 위한 변수
	public static String[][] maze;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로 크기
		M = sc.nextInt();
		// 세로 크기
		N = sc.nextInt();
		// 미로
		maze = new String[N][M];
		// 미로값 할당
		for (int i = 0; i < N; i++) {
			maze[i] = sc.next().split("");
		}

		dijkstra(0, 0, 0);
		
		System.out.println(min);
	}

	public static void dijkstra(int r, int c, int dep) {
		// 방문 기록 초기화
		visited = new boolean[N][M];
		// 문제 해결하기 위해 deque 사용
		Deque<int[]> deque = new LinkedList<>();
		// r: 행,c: 열,dep: 벽 부순 횟수
		// 시작점을 입력 받음
		deque.add(new int[] { r, c, dep });
		// deque가 빌 때까지 반복
		while (!deque.isEmpty()) {
			// deque에서 제일 앞 요소 제거
			int[] poll = deque.poll();
			// 행
			int pr = poll[0];
			// 열
			int pc = poll[1];
			// 벽 부순 횟수
			int pdep = poll[2];
			// 목표지점에 도착하게 되면 min과 비교해서 더 작은 값을 min으로 할당
			if (pr == N - 1 && pc == M - 1) {
				min = Math.min(min, pdep);
				return;
			}
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				// 범위 벗어나면 다음 반복으로 넘어가기
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 방문안했던 곳이면
				if (!visited[nr][nc]) {
					// 0인 경우 deque 앞쪽에 삽입
					if (maze[nr][nc].equals("0")) {
						visited[nr][nc] = true;
						deque.addFirst(new int[] { nr, nc, pdep });
						// 1인경우 deque 뒤쪽에 삽입
					} else if (maze[nr][nc].equals("1")) {
						visited[nr][nc] = true;
						// 부순 횟수 +1 해주기
						deque.addLast(new int[] { nr, nc, pdep + 1 });
					}
				}
			}
		}
	}
}