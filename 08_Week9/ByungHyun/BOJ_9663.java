package BOJ_9663_NQueen;

import java.util.Scanner;

public class Main {
	public static int[] queen;
	public static int n;
	public static int result = 0;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		queen = new int[n];
		
		visited = new boolean[n];
		
		nqueen(0);
		
		System.out.println(result);
	}
	
	// 체스판에 N번째 줄에 넣을 수있는 퀸의 위치
	public static void nqueen(int N) {
		// N이 n과 같아졌을때 결과값에 +1하고 리턴
		// queen의 조합을 완성했기때문에
		if (N == n) {
			result++;
			return;
		}
		
		// queen에 들어갈 수
		t : for (int i = 0; i < n; i++) {
			// 해당 위치를 방문했다면 다음 위치에 대해 조사
			if (visited[i]) {
				continue;
			}
			// 
			for (int j = 0; j < N; j++) {
				if (j - queen[j] == N - i || j + queen[j] == N + i) {
					continue t;
				}
			}
			// N줄에 i의 위치에 퀸을 놓는다. 방문처리도 진행 
			queen[N] = i;
			visited[i] = true;
			// 다음 위치에 대한 퀸의 위치값을 찾기위해서 재귀호출
			nqueen(N + 1);
			// 재귀가 끝났으면 해당 위치를 방문 안한것으로 처리
			visited[i] = false;
		}
		
	}
}
