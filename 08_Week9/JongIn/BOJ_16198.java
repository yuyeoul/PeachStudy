package BOJ_16198_에너지모으기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> energy; // 에너지 구슬의 무게를 담은 배열
	static int ans; // 정답

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 에너지 구슬의 개수
		energy = new ArrayList<>(); // 에너지 구슬의 무게를 담은 배열 선언
		ans = 0; // 에너지 합산값

		// N개만큼 데이터 추가해주기
		for (int i = 0; i < N; i++) {
			energy.add(sc.nextInt());
		}

		// 입력 확인
//		for (int i = 0; i < energy.size(); i++) {
//			System.out.print(energy.get(i) + " ");
//		}

		// 반복문으로 풀기
//		while (energy.size() >= 2) {
//
//			int max = 0;
//			int place = 0;
//			int tmpMax = 0;
//			for (int i = 1; i < energy.size() - 1; i++) {
//					tmpMax = energy.get(i - 1) * energy.get(i + 1);
//					if (max < tmpMax) {
//						max = tmpMax;
//						place = i;
//					}
//				} // 3개씩 검사 끝
//
//			ans += max;
//			energy.remove(place);
//			} // while 끝
//			
//			System.out.println(ans);
		
		energySum(N, 0); // 재귀 메서드 실행
		System.out.println(ans); // 정답 출력
		
		} // main 끝

	// 재귀
	public static void energySum(int n, int sum) {
		// 기저 조건
		if (n == 2) { // 메서드 사이즈가 2가 되면 실행 못함.
			ans = Math.max(sum, ans); // 최종 결과값 중 max값을 ans에 저장
			return;
		}
		else {
			// 탐색
			for (int i = 1; i < energy.size()-1; i++) {
				int tmp = energy.get(i-1)* energy.get(i+1); // 해당 위치에서 전, 후의 데이터를 곱한 임시 값
				int placeValue = energy.get(i); // 해당 위치에서의 저장값
				energy.remove(i); // 해당 위치 삭제해주고
				energySum(n-1, sum+tmp); // 재귀적으로 반복하면서 해당 위치에서 sum과 tmp를 반복해서 더해줌.
				energy.add(i, placeValue); // 재귀 호출이 완료되면, 선택한 요소를 다시 원래 위치에 추가
			}
			
		}
		
	} // 재귀 메서드 끝


} // class