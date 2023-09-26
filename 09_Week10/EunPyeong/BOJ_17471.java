import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471 {
	public static boolean[] visited;
	public static boolean[] sel;
	public static int N;
	public static int[] population;
	public static int[][] citys;
	public static List<Integer> min;
	public static int Acnt;
	public static int Bcnt;
	public static int aSum;
	public static int bSum;
	public static Queue<Integer> queueA;
	public static Queue<Integer> queueB;
	public static List<Integer> A;
	public static List<Integer> B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 구역수
		N = sc.nextInt();
		// 구역 인접행렬
		citys = new int[N + 1][N + 1];
		// 인구수
		population = new int[N + 1];
		// 인구수 값 할당
		for (int i = 1; i < population.length; i++) {
			population[i] = sc.nextInt();
		}
		// 인접행렬 연결
		for (int i = 1; i <= N; i++) {
			int connectedCnt = sc.nextInt();
			for (int j = 1; j <= connectedCnt; j++) {
				int connectedCity = sc.nextInt();
				citys[i][connectedCity] = 1;
				citys[connectedCity][i] = 1;
			}
		}
		// 부분집합 구하기 위한 배열 생성
		sel = new boolean[N + 1];


		// 구역 분할에 따른 인구수 차이값들 모음
		min = new ArrayList<>();
		
		// 부분집합 구하기
		powerset(1);
		// 인구수 오름차순 정렬
		Collections.sort(min);

		// 출력할 정답
		int answer;
		// 저장된 인구수가 없다면 지역구 분할이 안되는 것이기 때문에 -1 출력
		if (min.isEmpty()) {
			answer = -1;
			// 그 외는 최솟값 출력
		} else {
			answer = min.get(0);
		}

		System.out.println(answer);
	}

	// 부분집합 구하는 매서드
	public static void powerset(int idx) {

		if (idx == N) {
			visited = new boolean[N + 1];
			// 부분집합으로 선택된 요소를 담을 리스트
			A = new ArrayList<>();
			// 선택되지 않은 요소를 담을 리스트
			B = new ArrayList<>();
			// 요소 할당
			for (int i = 1; i < sel.length; i++) {
				if (sel[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}

			// 원소가 없는 경우(=지역구 구분안되는 경우) 리턴
			if (A.size() == 0 || B.size() == 0)
				return;
			// BFS사용을 위한 큐 생성
			queueA = new LinkedList<>();
			queueB = new LinkedList<>();
			// 해당 부분집합들의 총 인구수
			aSum = 0;
			bSum = 0;
			// 부분집합의 첫번째 값
			int Ae = A.get(0);
			int Be = B.get(0);
			// 부분집합의 크기
			Acnt = A.size();
			Bcnt = B.size();
			// BFS 실행
			int[] resultA = new int[2];
			resultA = BFS(queueA, A, aSum, Acnt, Ae);
			Acnt = resultA[0];
			aSum = resultA[1];

			// BFS 실행
			int[] resultB = new int[2];
			resultB = BFS(queueB, B, bSum, Bcnt, Be);
			Bcnt = resultB[0];
			bSum = resultB[1];

			// 지역이 분리가 가능한 경우
			if (Acnt == 0 && Bcnt == 0) {
				int diff = Math.abs(bSum - aSum);
				// min 리스트에 추가하기
				min.add(diff);
			}
			return;
		}

		powerset(idx + 1);
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;

	}

	// BFS (queue: 각 부분집합의 큐, list: 부분집합, sum: 각 부분집합의 총인구수, cnt: 각 부분집합의 크기,
	// firstEl: 각 부분집합의 첫번째 요소)
	public static int[] BFS(Queue<Integer> queue, List<Integer> list, int sum, int cnt, int firstEl) {
		// 첫번째 요소 추가
		queue.add(firstEl);
		// 방문처리
		visited[firstEl] = true;
		// 해당 인구수 추가
		sum += population[firstEl];
		// 크기 감소시키기
		cnt--;
		// queue의 크기가 0이 될때까지
		while (!queue.isEmpty()) {
			// 제거
			int poll = queue.poll();
			for (int i = 1; i < citys.length; i++) {
				// 1) 부분집합의 일부이면서 2) 방문한 적도 없으면서 3) 연결되어 있는 경우
				if (list.contains(i) && !visited[i] && citys[poll][i] == 1) {
					visited[i] = true;
					queue.add(i);
					sum += population[i];
					cnt--;
				}
			}
		}
		return new int[] { cnt, sum };
	}
}
