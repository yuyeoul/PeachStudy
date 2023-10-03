package BOJ_2665_미로만들기;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	// Node 설정
    static class Node implements Comparable<Node> {
        int row, col, cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    } // Node

    static int N;
    static int[][] maze;
    static int[][] dist;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N : 방의 크기, maze : N의 크기를 가진 미로
        N = sc.nextInt();
        maze = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        } // N*N 입력 끝

        // 시작 지점 ~ 거리 값 배열 초기화
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // dijkstra 메서드 실행
        int answer = dijkstra();
        System.out.println(answer);
    }

    public static int dijkstra() {
    	// 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작지점을 우선순위 큐에 넣고, 시작지점(0,0)에서의 거리는 0으로 설정
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
        	// 큐에서 가장 가까운 지점 꺼내기
            Node current = pq.poll();
            int r = current.row;
            int c = current.col;
            int cost = current.cost;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                	// 갈 수 있는 경로면 cost는 0, 검은색 방으로 흰색 방으로 바꿔야하면 cost는 1
                    int newCost = cost + (1 - maze[nr][nc]);
                    // 해당 경로가 새로운 비용으로 치환되면 (0 -> 1로) 값 변경해주고 새로운 노드로 저장
                    if (dist[nr][nc] > newCost) {
                        dist[nr][nc] = newCost;
                        pq.offer(new Node(nr, nc, newCost));
                    }
                }
            }
        }

        // 도착 결과값
        return dist[N - 1][N - 1];
    }
}