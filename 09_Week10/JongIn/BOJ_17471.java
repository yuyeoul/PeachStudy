package BOJ_17471_게리맨더링;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] population, p, number;
	static boolean[] visited;
	static Map<Integer, List<Integer>> person;
	static List<Integer> result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N : 구역의 개수, population = 각 구역의 인구 수, p : parent 집합
		N = sc.nextInt();
		p = new int[N + 1];
		population = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
		}

		// visited : 방문체크, number : 번호
		visited = new boolean[N + 1];
		number = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			number[i] = i;
		}
		// makeSet (하나짜리 집합 만들기)
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}

		person = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			person.put(i, new ArrayList<>());
		}

		// N번 반복 (N개의 번호에 대해 입력)
		for (int i = 1; i <= N; i++) {
			int M = sc.nextInt(); // 각 번호에 대해서 M번의 관계

			for (int j = 0; j < M; j++) {
				int x = sc.nextInt();
				person.get(x).add(i);
			}
		}
		// 해당 문제에서는 1번과 2번의 관계에 대해 양쪽에 다 주기 때문에 유향 그래프처럼 한번만 입력해도 된다.

		for (int i=1; i <= N; i++) {
			System.out.println(person.get(i).toString());
		}

		powerSet(1);

	} // main

	public static int findSet(int idx) {
		// Path Compression
		if (p[idx] != idx)
			return p[idx] = findSet(p[idx]);
		return p[idx];

	}

	public static void union(int pa, int pb) {
		if (pa == pb)
			return;
		p[pa] = pb;
	}

	public static void powerSet(int idx) {
		// 기저 조건
		if (idx == N) {
			// 모든 구역을 선거구로 나눴을 때
			boolean[] firstDistrict = new boolean[N+1];
			int district1 = 0;
			int district2 = 0;
			
			// 각 구역을 첫번째 선거구 또는 두번째 선거구에 할당
			for (int i = 1; i < N+1; i++) {
				if (visited[i]) {
					firstDistrict[i] = true;
					district1 += population[i];
				} else {
					firstDistrict[i] = false;
					district2 += population[i];
				}
			}
			
			
			
//			for (int i = 1; i <= N; i++) {
//				if (!visited[i]) {
//					System.out.print(number[i] + " ");
//				}
//
//			}
//			System.out.println();
			return;
		} else {
			// 재귀 조건
			visited[idx] = false;
			powerSet(idx + 1);
			visited[idx] = true;
			powerSet(idx + 1);


		}
	}

} // class
