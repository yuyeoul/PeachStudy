package BOJ_17179_케이크자르기;

import java.util.Arrays;
import java.util.Scanner;

// 이분탐색
public class Main {
	static int N, M, L;
	static int[] cutPlace;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 자르는 횟수가 담긴 목록의 길이 N과 자를 수 있는 지점의 개수 M, 그리고 롤 케이크의 길이인 정수 L
		// (1 ≤ N ≤ M ≤ 1,000, 1 < L ≤ 4,000,000)
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		cutPlace = new int[M];

		for (int i = 0; i < M; i++) {
			cutPlace[i] = sc.nextInt();
		} // 롤 케이크 자를 수 있는 부분 입력 끝

		// N번 자르는만큼 testCase 생성
		for (int t = 1; t <= N; t++) {
			// cutCount : 자른 조각의 갯수 (예제를 보면 3 4일 때 - testCase당 길이 L을 3번 자르는 경우, 4번 자르는 경우라고 생각)
			int cutCount = sc.nextInt();

			int start = 0;
			int end = L;

			// 시작지점 다음이 끝지점이 되기전까지 반복
			while (start + 1 < end) {
				// 중간 지점
				int mid = (start + end) / 2;

				// 만약 조각의 해당 지점에서 조각의 갯수가 주어진 값 이상이면 더 큰 값을 찾아야함.
				if (check(mid) > cutCount) {
					start = mid;
					// 반대는 작은 값 탐색
				} else {
					end = mid;
				}
			} // while문 끝

			// 출력
			System.out.println(start);
		} // testCase 끝

	} // main

	// 조각 갯수 판별
	private static int check(int cut) {
		// cut : 내가 구하고자 하는 값
		// count: 조각의 갯수
		int count = 0;
		// lastCutPlace: 마지막으로 자른 조각의 길이
		int lastCutPlace = 0;

		for (int i = 0; i < M; i++) {
			if (cutPlace[i] - lastCutPlace >= cut) {
				lastCutPlace = cutPlace[i];
				count++;
			}
		}

		// 마지막까지 조각이 되는지 검사
		if (L - lastCutPlace >= cut)
			count++;

		return count;
	}

} // class
