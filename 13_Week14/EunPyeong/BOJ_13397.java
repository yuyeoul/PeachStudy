import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_13397 {
	public static int N;
	public static int M;
	public static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열의 크기
		N = sc.nextInt();
		// 구간의 개수
		M = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		int end = max - min;

		System.out.println(binarySearch(end));
	}

	// 이분탐색
	public static int binarySearch(int num) {
		// 시작점
		int str = 0;
		// 끝점
		int end = num;
		// 결과값 담을 변수
		int result = Integer.MAX_VALUE;
		// 이분탐색
		while (str <= end) {
			// 중간 값
			int mid = (str + end) / 2;
			// 구간의 갯수를 담을 변수
			int cnt = 0;

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			// 구간 담기위한 리스트
			List<Integer> list = new ArrayList<>();
			// 반복
			for (int i = 0; i < N; i++) {
				// 리스트에 값 추가
				list.add(arr[i]);
				// 최대 최소값 갱신
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				// 구간이 나누어지는 경우
				if (max - min > mid) {
					// 구간 갯수 1더하기
					cnt++;
					// 마지막에 들어간 값으로 max, min 갱신
					max = arr[i];
					min = arr[i];
					// list 비우고 마지막에 들어간 값 넣어주기
					list.clear();
					list.add(arr[i]);
					// 마지막인데 구간이 나누어지는 경우 구간 갯수 1더하기
					// (= 마지막 숫자가 해당 구간에 포함되지 못하는 경우)
					if (i == N - 1) {
						cnt++;
					}
					// 마지막일땐 무조건 구간 갯수 1더하기
				} else if (i == N - 1) {
					cnt++;
				}
			}
			// 구간 합 크기 늘여주기
			if (cnt > M) {
				str = mid + 1;
				// 구간 합 크기 줄여주기
			} else if (cnt <= M) {
				result = Math.min(result, mid);
				end = mid - 1;
			}
		}
		return result;
	}
}