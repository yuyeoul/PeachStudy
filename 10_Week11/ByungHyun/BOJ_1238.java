package BOJ_1238_파티;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	public static int x;
	public static List<int[]>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n명의 학생
		n = sc.nextInt();
		// m 간선의 개수
		m = sc.nextInt();
		// x 의 정보
		x = sc.nextInt();
		
		// graph 초기화
		graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// graph 정보 받기
		for (int i = 0; i < m; i++) {
			// a에서 b정점으로 c의 비용으로 연결되어있다.
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph[a].add(new int[] {c, b});
		}
		
		int result = 0;
		
		// x에서 다른 정점사이의 거리 배열
		int[] distX = dijkstra(x);
		
		for (int i = 1; i < n + 1; i++) {
			// 각각의 정점에 대해서 연산을 진행한다.
			// x의 거리는 0이기때문에 제외하고 연산을 진행한다.
			if (i == x) {
				continue;
			} else {
				// 결과값을 x에서 i의 거리와 i에서 x로 거리와 비교하여 최대값을 구한다.
				// distX[i] : x -> i    dijkstra(i) : i에서 다른 정점의 거리    dijkstra(i)[x] : i -> x 거리
				result = Math.max(result, distX[i] + dijkstra(i)[x]);
			}
		}
		// 결과 출력
		System.out.println(result);
		
	}
	
	public static int[] dijkstra(int start) {
		// 거리 정보를 저장하기위한 배열
		int[] distance = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		// 비용을 기준으로 오름차순으로 간선의 정보를 얻기위한 우선순위 큐 생성
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 시작 정점에 대한 정보 우선순위 큐에 넣기
		distance[start] = 0;
		queue.add(new int[] {0, start});
		
		while (!queue.isEmpty()) {
			// queue가 빌때까지
			int[] data = queue.remove();
			
			// 연결된 정점에 대해서
			for (int[] end : graph[data[1]]) {
				int cost = data[0] + end[0];
				
				if (cost < distance[end[1]]) {
					distance[end[1]] = cost;
					queue.add(new int[] {cost, end[1]});
				}
			}
		}
		
		return distance;
	}
}
