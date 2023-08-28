package BOJ_11726_2n타일링;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 2*N 크기의 직사각형

		long[] tile = new long[N + 1]; // 1~1000까지의 타일

		// 0번쨰는 없겠지만 피보나치 수열을 위해서 작성
		tile[0] = 1;
		tile[1] = 1; // tile이 2*1이면 1칸

		for (int i = 2; i <= N; i++) {
			if (i >= 2) { // tile이 2*2면 2칸  = tile[0] + tile[1]
				tile[i] = (tile[i - 1] + tile[i - 2]) % 10007;
				// tile[3] = 1+2, tile[4] = 2+3, tile[5] = 3+5 ...
			}
		}
		// 확인용
//		System.out.println(Arrays.toString(tile));

		System.out.println(tile[N]);

	} // main

} // class
