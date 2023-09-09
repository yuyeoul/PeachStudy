package BOJ_6603_로또;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n; // 조합에 포함되는 갯수
	static int[] k; // n개의 갯수만큼 수를 가진 배열
	static int[] rotto = new int[6]; // 로또 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) { // 입력받는 숫자의 개수가 0이 아니라면 계속 반복하기

			n = sc.nextInt(); // 조합에 포함되는 갯수

			if (n == 0) { // 입력받는 숫자 n이 0이라면 종료
				break;
			}

			k = new int[n]; // 갯수만큼 숫자를 담을 배열

			// n개의 숫자 입력 받기
			for (int i = 0; i < n; i++) {
				k[i] = sc.nextInt();
			} // 입력 끝

			// 입력 확인
//			System.out.println(Arrays.toString(k));

			combination(0, 0);
			System.out.println();

		} // while문 끝

	} // main

	public static void combination(int idx, int sidx) {

		// 기저파트
		if (sidx == 6) {
			for (int i = 0; i < rotto.length; i++) {
				System.out.print(rotto[i]);
				if (i < rotto.length - 1) {
					System.out.print(" "); // 마지막 숫자 뒤에 공백 출력 안하게!!
				}
			}
			System.out.println(); // 끝나면 다음 줄
			return;
		}

		// 재귀파트
		for (int i = idx; i <= n - 6 + sidx; i++) {
			rotto[sidx] = k[i];
			combination(i + 1, sidx + 1);
		}

	}

} // class
