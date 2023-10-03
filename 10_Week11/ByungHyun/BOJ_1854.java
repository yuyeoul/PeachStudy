package BOJ_1854_K번째최단경로찾기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도시들의 개수 (정점의 수)
		int n = sc.nextInt();
		// 도시간에 존재하는 도로의 수 (간선의 수)
		int m = sc.nextInt();
		// 1번부터 i번 도시로 가는 최단경로 중 k번째
		int k = sc.nextInt();
		
		// graph생성 인접 리스트 생성
		List<int[]>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 각각의 정점에 대해서 우선순위 큐를 생성
		// 해당 정점에 도착하는 거리에 대한 정보를 넣기 위해서 내림차순으로 정렬한다.
		PriorityQueue<Integer>[] distance = new PriorityQueue[n + 1];
		for (int i = 1; i <= n; i++) {
			distance[i] = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}
		
		// 도시들 간의 정보 받기 인접 리스트에 정보 받기
		for (int i = 0; i < m; i++) {
			// a번 도시에서 b번 도시로 갈때 걸리는 시간 c
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			// 방향이 있는 그래프
			graph[a].add(new int[] {c, b});
		}
		
		// 다익스트라 알고리즘을 이용하기위한 우선순위 큐 생성
		// 첫번째 원소(거리)를 오름차순 기준으로 우선순위큐에 넣는다.
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 초기값 넣기 시작 지점에 대한 정보를 큐에 넣기
		queue.add(new int[] {0, 1});
		// 1번 정점에 대해 처음 거리를 0으로 넣는다.
		distance[1].add(0);
		
		while (!queue.isEmpty()) {
			// queue가 빌때 까지
			// queue의 정보 받기
			// data[0] : 거리 정보, data[1] : 정점 정보
			int[] data = queue.remove();
			
			for (int[] dest : graph[data[1]]) {
				// 정점과 연결된 정점으로 가기 위해서
				// dest[0] : 현재 정점과 목적지 정점 사기의 거리  dest[1] : 목적지 정점
				// 거리의 합
				int dist = dest[0] + data[0];
				if (distance[dest[1]].size() < k) {
					// 목적지의 거리 정보의 개수가 k보다 작으면 넣는다.
					distance[dest[1]].add(dist);
					// queue에도 정보를 넣는다. [거리, 정점]
					queue.add(new int[] {dist, dest[1]});
				} else if (distance[dest[1]].peek() > dist) {
					// 해당 정점에 대해서 k개가 채워져있다.
					// 해당 정점에서 거리의 최대값이 현재 넣을려는 거리보다 크다면 빼줘야됨
					distance[dest[1]].remove();
					distance[dest[1]].add(dist);
					// queue에도 정보 넣기
					queue.add(new int[] {dist, dest[1]});
				}
			}
		}
		// 정점으로 부터 거리를 출력
		for (int i = 1; i <= n; i++) {
			// 만약 distance의 queue의 길이가 k보다 작으면 k번째 최단경로가 없다는 뜻이다. 그러면 -1을 출력
			if (distance[i].size() < k) {
				System.out.println(-1);
			} else {
				System.out.println(distance[i].remove());
			}
		}
	}
}
