package BOJ_2563_색종이;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스는 아니지만 입력 횟수. // 이 경우는 3

		int[][] arr = new int[100][100]; // 가로, 세로 도화지의 크기: 100

		for (int t = 1; t <= T; t++) {

			int numA = sc.nextInt();
			int numB = sc.nextInt();

			// i,j열만큼 이동
			for (int i = numA; i < numA + 10; i++) {
				for (int j = numB; j < numB + 10; j++) {

					// 범위 배열 안에서
					if (numA + 10 <= 100 && numB + 10 <= 100) {
						arr[i][j] = 1;
					}

				}

			}

		} // 입력횟수만큼 색종이 붙이기 끝

		int sum = 0;

		// 색종이 배열에 1로 되어있으면 더해주기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					sum += arr[i][j];
				}
			}
		}

		System.out.println(sum);

	}
}
