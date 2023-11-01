package BOJ_1300_K번째수;

import java.util.Scanner;

public class Main {
	public static long n;
	public static long mid;
	public static void main(String[] args) {
		// n이 3일때 오름차순으로 정렬하면
		// [1, 2, 2, 3, 3, 4, 6, 6, 9]
		
		Scanner sc = new Scanner(System.in);
		
		// 배열의 크기
		n = sc.nextLong();
		// k의 값 k는 min(10^9, n^2);
		long k = Math.min(1000000000, sc.nextLong());
		
		// 시작
		long start = 1;
		// 끝
		long end = n * n;
		
		while (start <= end) {
			// mid
			mid = (start + end) / 2;
			// 찾고자하는 mid보다 작거나 같은 수의 개수
			long count = getCount(mid);
			// mid보다 작은수의 개수가 찾고자하는 인덱스보다 크다면 end값을 변화시킨다.
			if (count >= k) {
				end = mid - 1;
			} else {
				// count가 작다면
				start = mid + 1;
			}
		}
		
		System.out.println(start);
	}
	
	// 해당 숫자보다 작은 수의 개수를 세는 메서드
	public static long getCount(long num) {
		long result = 0;
		// 몫을 더하면 num보다 작은 수의 개수를 구할 수있음
		for (int i = 1; i <= n; i++) {
			// 배열의 크기가 최대 n이기때문에 n과 num / i의 최소값
			result += Math.min(n, num / i);
		}
		// 결과 리턴
		return result;
	}
}
