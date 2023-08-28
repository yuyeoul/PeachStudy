package BOJ_11054_가장긴바이토닉부분수열;

import java.util.Scanner;

public class BOJ_11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 크기
		int n = sc.nextInt();

		// 최대 수열의 길이
		int result = 0;

		// 수열의 정보를 담기위한 배열 생성
		int[] arr = new int[n];

		// 데이터 받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 바이토닉 수열에 대한 길이를 담을 2차원 dp테이블 생성
		int[][] dp = new int[n][n];

		for (int maxindex = 0; maxindex < n; maxindex++) {
			// maxindex를 기준으로 왼쪽은 증가하는 수열 오른쪽은 감소하는 수열의 길이를 받기

			// 왼쪽에 해당하는 증가하는 수열의 길이를 작성
			for (int i = 1; i <= maxindex; i++) {
				for (int j = 0; j < i; j++) {
					// 0부터 i인덱스 전까지 i와 비교하여 i인덱스의 값이 크다면 증가하는 수열
					if (arr[i] > arr[j]) {
						// 길이의 최대값을 구한다.
						// 해당 i인덱스의 길이와 j인덱스에서의 값에 +1을 하여 비교
						dp[maxindex][i] = Math.max(dp[maxindex][i], dp[maxindex][j] + 1);
					}
				}
			}

			// 오른쪽에 해당하는 감소하는 수열의 길이를 작성
			for (int i = maxindex + 1; i < n; i++) {
				for (int j = maxindex; j < i; j++) {
					// 0부터 i인덱스 전까지 i와 비교하여 i인덱스의 값이 작다면 감소하는 수열
					if (arr[i] < arr[j]) {
						dp[maxindex][i] = Math.max(dp[maxindex][i], dp[maxindex][j] + 1);
					}
				}
			}
		}
		
		// 부분 수열중 가장 큰 값을 찾기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dp[i][j]);
			}
		}
		// 초기값을 0으로 설정했기 때문에 결과에 +1
		System.out.println(result + 1);

	}

}
