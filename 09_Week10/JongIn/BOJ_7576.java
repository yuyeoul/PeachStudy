package BOJ_7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    static int N, M, day;
    static int[][] box;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N : 상자의 세로 칸 수, M : 상자의 가로 칸 수  (2 ≤ M,N ≤ 1,000)
        M = sc.nextInt();
        N = sc.nextInt();

        box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 0 : 안 익은 토마토, 1 : 잘 익은 토마토, -1 : 토마토 없음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j, 0}); // 익은 토마토의 위치와 날짜를 큐에 추가
                }
            }
        } // 토마토 입력 끝

        day = 0; // 익는데 걸리는 시간

        // BFS 탐색
        while (!queue.isEmpty()) {
        	// 토마토 배열을 queue에 넣고 r,c와 시간에 대해 탐색
            int[] tomato = queue.poll();
            int r = tomato[0];
            int c = tomato[1];
            int currentDay = tomato[2];

            day = Math.max(day, currentDay); // 현재 날짜 갱신

            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 배열 범위 안에 있고 안 익은 토마토일 때
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
                    box[nr][nc] = 1; // 익은 토마토로 변경
                    queue.add(new int[]{nr, nc, currentDay + 1});
                }
            }
        }

        // 모든 토마토가 익은 상태가 아니라면 -1 출력, 아니면 최소 일수 출력
        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false; // 익지 않은 토마토가 있으면 false 반환
                }
            }
        }
        return true; // 모든 토마토가 익었으면 true 반환
    }
}