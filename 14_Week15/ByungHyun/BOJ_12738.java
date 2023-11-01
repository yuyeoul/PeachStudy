package BOJ_12738_가장긴증가하는부분수열3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] data = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증가하는 부분수열의 정보를 저장할 배열
		dp = new int[n];
		// 부분수열의 길이 data의 첫번째 값은 무조건 들어감
		int len = 1;
		// 초기값 설정하기
		dp[0] = data[0];
		// arr을 방문하면서 비교
		for (int i = 1; i < n; i++) {
			// 부분수열의 최대값과 비교했을때 data[i]가 크다면 부분수열에 넣어야한다.
			if (data[i] > dp[len - 1]) {
				dp[len++] = data[i];
			} else {
				// 그렇지 않다면 넣을수 있는 곳 중에서 가장 인덱스가 작은 곳에 넣는다.
				// 넣는 인덱스를 이분탐색으로 찾기.
				int index = bSearch(0, len, data[i]);
				dp[index] = data[i];
			}
		}
		System.out.println(len);
	}
	
	// 해당 배열 중에서 num보다 같은 것들 중에서 인덱스가 가장 작은 곳
	public static int bSearch(int start, int end, int num) {
		while (start < end) {
			// 중간값
			int mid = (start + end) / 2;
			
			if (dp[mid] < num) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}
}
