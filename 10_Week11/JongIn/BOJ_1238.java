package BOJ_1238_파티;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	// N : 각 마을의 번호, M : 단방향 도로(간선), X: 파티장소
	static int N, M, X;
	static List<ArrayList<Node>> list;

	static class Node implements Comparable<Node> {
		// roadNum = 도로 번호, time = 시간
		int roadNum;
		int time;

		public Node(int roadNum, int time) {
			this.roadNum = roadNum;
			this.time = time;
		}

		// 시간 비교 override
		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}
	} // Node class 끝

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N : 각 마을의 번호, M : 단방향 도로(간선), X: 파티장소
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		// 단방향 도로 정보 입력받기
		for (int i = 0; i < M; i++) {
			// A: 출발, B: 도착, T : 걸리는 시간
			int A = sc.nextInt();
			int B = sc.nextInt();
			int T = sc.nextInt();

			list.get(A).add(new Node(B, T));

		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			// 자기 자신이면 제외
			if (i == X)
				continue;
			// from : 출발마을→ 파티장소, to: 파티장소→ 도착마을
			int fromResult = dijkstra(i, X);
			int toResult = dijkstra(X, i);

			max = Math.max(max, fromResult + toResult);
		}

		System.out.println(max);
	} // main

	public static int dijkstra(int start, int end) {
		// 우선순위 Queue, 방문처리 visited, 거리 distance 배열 선언
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[N + 1];
		int distance[] = new int[N + 1];

		// 거리 배열 값 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			// idx : 방문한 노드 번호
			int idx = node.roadNum;

			if (!visited[idx]) {
				visited[idx] = true;
				// 현재 idx번호 노드에 연결된 방문 순회
				for (Node n : list.get(idx)) {
					// 방문 체크 확인 및 거리 검사 (다른 노드를 통해서 거리보다 짧은지)
					if (!visited[n.roadNum] && distance[n.roadNum] > (distance[idx] + n.time)) {
						// 거리 검사 후 더 짧은 경로 있으면 업데이트 후 우선순위 큐에 추가
						distance[n.roadNum] = distance[idx] + n.time;
						pq.offer(new Node(n.roadNum, distance[n.roadNum]));
					}
				}

			}

		} // while 반복문 끝
		// 최단거리 반환
		return distance[end];
	} // dijkstra 메서드 끝
} // class