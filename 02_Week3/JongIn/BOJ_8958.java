package BOJ;

import java.util.Scanner;

public class _8958 {
	public static void main(String[] args) {
		// OX퀴즈
		// 반복된 O일경우 점수가 계속해서 증가
		// 예를 들어, 10번 문제의 점수는 3이 된다.
		// "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
		// X를 만나면 해당 열에 점수를 0으로 초기화

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 테스트 케이스 수 입력

		for (int t = 0; t < N; t++) { // 테스트 케이스
			String arr = sc.next(); // 테스트 케이스 내에서 String ox 받아오기

			int count = 0; // 연속 횟수
			int sum = 0; // 합산점수

			// 테스트 케이스 별로 o,x 입력
			for (int i = 0; i < arr.length(); i++) { // ox 길이만큼 반복
				if (arr.charAt(i) == 'O') { // O가 연속으로 맞으면
					count += 1; // 처음 연속횟수 +1, 다음엔 +2, 그 다음은, +3
				} else {
					count = 0; // 아니면 0으로 초기화
				}
				sum += count; // if, else문 통과 후에 count된 점수 더해주기

			}
			// 반복문이 끝났을 때 각 케이스별 점수
			System.out.println(sum);
		}

	}
}