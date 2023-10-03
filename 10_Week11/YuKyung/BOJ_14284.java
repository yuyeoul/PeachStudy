package STUDY;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_14284 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 정점의 개수
        int m = sc.nextInt();  // 간선의 개수

        // 그래프를 인접 리스트로 표현 (이중 리스트)
        // 바깥쪽 리스트는 정점의 개수만큼 초기화, n개의 정점을 표현하기 위한 리스트
        // 정점에서 연결된 간선들을 저장하는 리스트, 비어있음
        List<List<int[]>> graph = new ArrayList<>(n); 
        
        // 바깥쪽 리스트에 내부 리스트 추가하는 과정 반복
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); 
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 간선의 시작 정점
            int b = sc.nextInt(); // 간선의 도착 정점
            int c = sc.nextInt(); // 간선의 가중치
            
            // 양방향 간선 추가
            // get함수로 정점 'a'에서 시작한 간선들을 저장한 리스트 가져와서
            // 도착정점 b-1이랑 가중치 c로 구성된 배열, 그니까 간선 추가
            graph.get(a - 1).add(new int[]{b - 1, c});
            graph.get(b - 1).add(new int[]{a - 1, c});
        }

        int s = sc.nextInt() - 1;  // 시작 정점
        int t = sc.nextInt() - 1;  // 목표 정점

        // 시작 정점에서 목표 정점까지의 최단 거리 계산 (다익스트라)
        long[] dist = new long[n]; // 각 정점까지의 최단거리 저장하겠어요
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE; // 무한대로 초기화
        }
        dist[s] = 0; // 시작정점 s에서 자기 자신까지 거리 0이니까

        // pq: 우선순위 큐, 각 정점의 거리 관리해보자
        // 거리를 기준으로 가장 짧은 거리 가진 정점이 우선처리되도록 정렬해주자
        PriorityQueue<int[]> pq = new PriorityQueue<>( 에휴... );
        pq.add( 뭐 해야하징... ); // 시작정점인 s와 거리 0을 가진 배열 큐에 추가 -> 시작 정점에서 출발하는 것으로 초기화됨 + 다음으로 탐색할 정점들이 큐에 추가됨

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // 제일 짧은거 꺼내서 current에 저장
            int u = current[0]; // 정점의 idx
            long weight = current[1]; // 정점까지의 거리

            if (weight > dist[u]) { // 지금 거리가 배열의 거리보다 길면 무시혀
                continue;
            }

            // 현재 정점과 연결된 모든 이웃 정점을 반복하며 최단 거리 업데이트
            // 시작 정점에서 이웃 정점까지의 새로운 거리 저장해서
            // 그 거리가 현재 저장된 거리보다 짧으면 업데이트 하는... 그런... 거 구현 해보자...
            for (int i = 0; i < graph.get(u).size(); i++) {
                int[] neighbor = graph.get(u).get(i);
                int v = neighbor[0]; // 이웃 정점
                long alt = dist[u] + neighbor[1]; // 시작 정점에서 이웃 정점까지의 새로운 거리

                // 새로운 거리가 현재 저장된 거리보다 짧으면 업데이트, 아님 말아라
                if (alt < dist[v]) {
                    dist[v] = alt;
                    pq.add(new int[]{v, alt});
                }
            }
        
        }

        System.out.println(dist[t]); // 결과 출력
    }
}