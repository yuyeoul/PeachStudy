package STUDY;

import java.util.Scanner;

public class BOJ_1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 정점의 개수
        int M = sc.nextInt();  // 간선의 개수
        int X = sc.nextInt();  // 목적지 정점

        int[][] dist = new int[N + 1][N + 1];

        // 모든 정점 쌍 사이의 최단 거리 초기값을 1,000,000로 설정 (더 작으면 갱신해줄거라서)
        // 인데 자기 자신으로 가는 경로의 길이는 항상 0이기 때문에 대각선은 0으로
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 1000000;
                }
            }
        }

        // 간선 정보 입력해주고 쌍 사이의 거리를 설정
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();  // 출발 정점
            int n2 = sc.nextInt();  // 도착 정점
            int t = sc.nextInt();   // 거리 또는 시간

            dist[n1][n2] = t;  // 출발 정점에서 도착 정점까지의 거리 설정
        }

        // 모든 정점 쌍 사이의 최단 거리를 계산해서 갱신
        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                	// 현재 저장된 i에서 j로 가는 최단 거리와
                	// i에서 k를 거쳐서 j로 가는 거리 비교해서
                	// 더 작으면 갱신
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        int ans = 0;
        
        // 모든 정점(X빼고)에서 X로 가는 최단 거리와 
        // X에서 모든 정점으로 가는 최단 거리 계산하여 가장 큰 값 찾음
        for (int i = 1; i <= N; i++)
            if (i != X)
                ans = Math.max(ans, dist[i][X] + dist[X][i]);

        System.out.println(ans);  // 결과 출력
    }
}