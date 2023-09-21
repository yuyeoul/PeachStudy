package BOJ_9663_NQueen;

import java.util.Scanner;

// 다시 풀기
public class Main4 {
	static int N; // N*N 체스판의 크기
	static int[] pos; // 각 열에 있는 퀸의 위치
	static int cnt; // 경우의 수
	static boolean[] visited_a; // 같은 행에 방문 했는지 체크
	static boolean[] visited_b; // (/) 대각선 방향 방문했는지 체크
	static boolean[] visited_c;// (\) 대각선 방향 방문했는지 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pos = new int[N];
		visited_a = new boolean[N];
		visited_b = new boolean[N*2-1];
		visited_c = new boolean[N*2-1];

		set(0);
		System.out.println(cnt);

	} // main 메서드 끝

	public static void set(int i) { // i = 열
		for (int j = 0; j < N; j++) { // j = 행
			if (visited_a[j] == false && visited_b[i+j] == false && visited_c[i-j+N-1] == false) { // 해당 열에 행을 방문하지 않았다면
				pos[i] = j; // i번째 열에 있는 퀸을 j행에 배치

				// 기저 조건
				if (i == N - 1) {
					cnt++; // 카운트 한 개씩 추가
				}
				// 재귀 조건
				else {
					visited_a[j] = true; // i번째에 있는 것을 j행에 배치했으니 true로 방문했다고 판단.
					visited_b[i+j] = true; // (/) 대각선 방향 방문
					visited_c[i-j+N-1] = true; // (\) 대각서 방향 방문
					set(i + 1); // 그러면 다음 열을 배치해야함.
					visited_a[j] = false; // 돌아올 때 다시 false로 만들어주기
					visited_b[i+j] = false; 
					visited_c[i-j+N-1] = false;
				}
			} // 방문 검사까지 끝
		} // j행 반복문 끝

	} // set메서드 끝

} // class
