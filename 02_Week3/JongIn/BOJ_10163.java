package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _10163 {
	public static void main(String[] args) {
		// 색종이
		// 색종이의 위치값과 넓이를 구한다.
		// 겹치는 부분을 빼려면 어떻게 해야할까?

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이의 개수 입력
		int[] square = new int[101]; // N장의 색종이의 면적
		int[][] plane = new int[1001][1001]; // 색종이 평면

		for (int T = 1; T <= N; T++) { // 색종이의 개수만큼 반복하기
			int x = sc.nextInt(); // 처음 시작점(x축)
			int y = sc.nextInt(); // 처음 시작점(y축)
			int w = sc.nextInt(); // 좌우 길이
			int h = sc.nextInt(); // 상하 높이

			for (int i = x; i < x + w; i++) { // 좌우 처음 시작점 ~ 끝 지점
				for (int j = y; j < y + h; j++) { // 상하 처음 시작점 ~ 끝지점
					plane[i][j] = T; // 해당 지점을 1, 2, 3... 으로 바꾸기
				} // 그런데 1보다 2가, 2보다 3이 나중이므로 뒤에 숫자에서 덧칠한다는 느낌으로
			}
		}

		// 주어진 평면에서 번호가 1번이면 squre[1]에 +1
		// 번호가 2번이면 squre[2]에 +1 .. 이런 식으로 각 번호만 더해주기
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane.length; j++) {
				square[plane[i][j]] += 1; // 
			}
		}
		
		// 1번 번호의 square 값부터 나열하기
		for (int i = 1; i <= N; i++) {
			System.out.println(square[i]);
		}

	}

}
