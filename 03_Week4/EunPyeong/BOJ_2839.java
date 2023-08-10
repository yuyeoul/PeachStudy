import java.util.Scanner;

public class BOJ_2839 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 배달해야하는 설탈의 무게
		int N = sc.nextInt();
		// 최소한의 봉지수
		int minCount = Integer.MAX_VALUE;
		// 5로 설탕의 무게가 딱 나누어떨어지는 경우
		if (N % 5 == 0) {
			// 그때의 봉지수가 최소
			minCount = N / 5;
			// 딱 나누어 떨어지지 않는 경우
		} else {
			// 반복 시작지점 설정(5로 N을 나누었을 때 최대 몫)
			int max5 = N / 5;
			for (int count5 = max5; count5 >= 0; count5--) {
				int count3 = (N - 5 * count5) / 3;
				if (count5 * 5 + count3 * 3 == N) {
					minCount = count5 + count3;
					break;
				}
			}
			// 정확하게 나누어 떨어지는 수가 없는 경우
			if (minCount == Integer.MAX_VALUE) {
				minCount = -1;
			}
		}
		System.out.println(minCount);
	}
}
