import java.util.Scanner;

public class BOJ_2343 {
	public static int N;
	public static int M;
	public static int[] classes;
	public static long sum;
	public static long max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 강의 수
		N = sc.nextInt();
		// 블루레이의 갯수
		M = sc.nextInt();
        // 강의
		classes = new int[N];
        // 이분탐색 최대값
		sum = 0;
        // 이분탐색 최솟값
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			classes[i] = sc.nextInt();
			sum += classes[i];
			max = Math.max(classes[i], max);
		}
		System.out.println(binarySearch());
	}

	public static long binarySearch() {
		long str = max;
		long end = sum;
		long ans = Integer.MAX_VALUE;
		long mid = 0;
		while (str <= end) {
			// 블루레이 갯수
			int classCnt = 0;
			mid = (str + end) / 2;
			// 블루레이 크기
			int classSum = 0;
			for (int i = 0; i < N; i++) {
				classSum += classes[i];
				// 블루레이 크기가 mid인 경우
				if (classSum == mid) {
					classCnt++;
					classSum = 0;
					// 블루레이 크기가 mid보다 큰 경우
				} else if (classSum > mid) {
					classCnt++;
					// 블루레이 크기 값 초기화
					classSum = classes[i];
				}
				// 마지막 강의의 경우
				if (classSum != 0 && i == N - 1) {
					classCnt++;
				}
			}
			if (classCnt <= M) {
				ans = Math.min(mid, ans);
				end = mid - 1;
			} else {
				str = mid + 1;
			}
		}
		return ans;
	}
}