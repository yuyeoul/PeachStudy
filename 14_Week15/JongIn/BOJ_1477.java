package BOJ_1477_휴게소세우기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 현재 휴게소의 개수
		int M = sc.nextInt(); // 추가로 지으려고 하는 휴게소의 개수
		int L = sc.nextInt(); // 고속도로의 길이

		int[] restStations = new int[N + 2];
		restStations[0] = 0; // 시작 지점
		restStations[N + 1] = L; // 끝 지점

		for (int i = 1; i <= N; i++) {
			restStations[i] = sc.nextInt();
		} // 입력 끝
			// 정렬
		Arrays.sort(restStations);

		// 초기값 세팅 (이게 왜 제일 중요해..?)
		int left = 1;
		int right = L-1;

		while (left < right) {
			int mid = (left + right) / 2;
			// 휴게소의 갯수
			int count = 0;
			// 위치의 차이를 mid로 나눴을 때의만큼 갯수를 더해주기
			for (int i = 1; i <= N + 1; i++) {
				count += (restStations[i] - restStations[i - 1] - 1) / mid;

			}
			// 갯수확인 후 mid값 조정
			if (count > M) {
				left = mid + 1;
			} else {
				right = mid;
			}
		} // while문 끝
		// 출력
		System.out.println(left);
	}
}
